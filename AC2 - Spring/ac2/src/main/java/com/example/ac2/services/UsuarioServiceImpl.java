package com.example.ac2.services;

import java.util.List;
import java.util.stream.Collectors;

import com.example.ac2.dtos.ResultadoUsuarioDTO;
import com.example.ac2.dtos.UsuarioDTO;
import com.example.ac2.exceptions.RegraNegocioException;
import com.example.ac2.models.ResultadoUsuario;
import com.example.ac2.models.Usuario;
import com.example.ac2.repositories.ResultadoUsuarioRepository;
import com.example.ac2.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ResultadoUsuarioRepository resultadoUsuarioRepository;

    @Override
    @Transactional
    public Usuario salvar(UsuarioDTO usuarioDTO) {

        ResultadoUsuario resul = resultadoUsuarioRepository
                .findById(UsuarioDTO.getResultadoUsuarioId())
                .orElseThrow(() -> new RegraNegocioException("Resultado não encontrado"));

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setUsuario(usuarioDTO.getUsuario());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setResultadoUsuario(resul);
        return usuarioRepository.save(usuario);
    }

    @Override
    public ResultadoUsuarioDTO obterResultadoPorId(Long id) {
        return usuarioRepository.findById(id).map((Usuario c) -> return ResultadoUsuarioDTO.builder()
                    .id(c.getId())
                    .nome(c.getNome())
                    .email(c.getEmail())
                    .senha(c.getSenha())
                    .resultado(ResultadoUsuarioDTO.builder()
                            .id(c.getResultadoUsuarioId().getId())
                            .nome(c.getResultadoUsuario().getNome())
                            .build())
                    .build();
        }).orElseThrow(() -> new RegraNegocioException("Resultado não encontrado."));
    }

    @Override
    @Transactional
    public void remover(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void editar(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Usuario não encontrado"));
        ResultadoUsuario resultado = resultadoUsuarioRepository.findById(
                usuarioDTO.getResultadoUsuarioId())
                .orElseThrow(() -> new RegraNegocioException("Resultado não encontrado"));
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setUsuario(usuarioDTO.getUsuario());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setResultadoUsuario(resultado);
        usuarioRepository.save(usuario);
    }

    @Override
    public List<ResultadoUsuarioDTO> obterTodos() {
        return usuarioRepository.findAll().stream().map((Usuario c) -> {
            return ResultadoUsuarioDTO.builder()
                    .id(c.getId())
                    .nome(c.getNome())
                    .email(c.getEmail())
                    .senha(c.getSenha())
                    .resultado(ResultadoUsuarioDTO.builder()
                            .id(c.getCategoriaCurso().getId())
                            .nome(c.getCategoriaCurso().getNome())
                            .build())
                    .build();
        }).collect(Collectors.toList());
    }
}
