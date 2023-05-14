package com.example.ac2.services;

import org.springframework.stereotype.Service;

import com.example.ac2.dtos.ResultadoUsuarioDTO;
import com.example.ac2.models.ResultadoUsuario;
import com.example.ac2.repositories.ResultadoUsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResultadoUsuarioServiceImp {
    private final ResultadoUsuarioRepository resultadoUsuarioRepository;

    @Override
    public ResultadoUsuario salvar(ResultadoUsuarioDTO re) {
        ResultadoUsuario categ = new ResultadoUsuario();
        categ.setNome(dto.getNome());
        return resultadoUsuarioRepository.save(categ);
    }

}
