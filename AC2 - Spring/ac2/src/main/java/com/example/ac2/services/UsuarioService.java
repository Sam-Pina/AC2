package com.example.ac2.services;

import java.util.List;

import com.example.ac2.dtos.ResultadoUsuarioDTO;
import com.example.ac2.dtos.UsuarioDTO;
import com.example.ac2.models.Usuario;

public interface UsuarioService {
    Usuario salvar(UsuarioDTO usuarioDTO);

    ResultadoUsuarioDTO obterResultadoPorId(Long id);

    void remover(Long id);

    void editar(Long id, UsuarioDTO usuarioDTO);

    List<ResultadoUsuarioDTO> obterTodos();
}
