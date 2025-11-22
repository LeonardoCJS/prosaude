package com.example.pulseira.monitoramento.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class FuncionarioResponseDTO {
    private Long id;
    private String nome;
    private Integer idade;
    private String setor;
    private String cargo;
}
