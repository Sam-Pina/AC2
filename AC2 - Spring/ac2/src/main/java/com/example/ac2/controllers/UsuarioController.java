package com.example.ac2.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.dtos.ResultadoUsuarioDTO;
import com.example.ac2.dtos.UsuarioDTO;
import com.example.ac2.models.Usuario;
import com.example.ac2.services.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;
public UsuarioController(UsuarioService usuarioService) {
this.usuarioService = usuarioService;
}
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public Usuario salvar(@RequestBody UsuarioDTO usuarioDTO) {
    Usuario c = usuarioService.salvar(usuarioDTO);
return c;
}
@GetMapping("{id}")
public ResultadoUsuarioDTO getCursoPorId(@PathVariable Long id) {
    return usuarioService.obterResultadoPorId(id);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCurso(@PathVariable Long id) {
        usuarioService.remover(id);
    }
    @PutMapping("{id}")
    public void editCurso(@PathVariable Long id, @RequestBody UsuarioDTO dto) {
        usuarioService.editar(id, dto);
    }
    @GetMapping
    public List<ResultadoUsuarioDTO> getCursos() {
    return usuarioService.obterTodos();
    }
}
