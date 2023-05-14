package com.example.ac2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.dtos.ResultadoUsuarioDTO;
import com.example.ac2.models.ResultadoUsuario;
import com.example.ac2.services.ResultadoUsuarioService;

@RestController
@RequestMapping("/api/resultadoUsuario")
public class ResultadoUsuarioController {
    private ResultadoUsuarioService resultadoUsuarioService;

    public ResultadoUsuarioController(ResultadoUsuarioService resultadoUsuarioService) {
    this.resultadoUsuarioService = resultadoUsuarioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultadoUsuario salvar(@RequestBody ResultadoUsuarioDTO dto) {
        return resultadoUsuarioService.salvar(dto);
    }

}
