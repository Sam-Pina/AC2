package com.example.ac2.services;

import com.example.ac2.dtos.ResultadoUsuarioDTO;
import com.example.ac2.models.ResultadoUsuario;

public interface ResultadoUsuarioService {
    ResultadoUsuario salvar(ResultadoUsuarioDTO dto);
}
