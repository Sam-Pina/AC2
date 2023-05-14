package com.example.ac2.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ResultadoUsuarioDTO {
    private Long id;
    private String areaAtuacao;
    private String total;
}
