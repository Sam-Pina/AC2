package com.example.ac2.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String usuario;
    private String email;
    private String senha;
    public static Long getResultadoUsuarioId() {
        return null;
    }
}
