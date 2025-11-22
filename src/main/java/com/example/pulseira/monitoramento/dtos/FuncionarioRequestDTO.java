package com.example.pulseira.monitoramento.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FuncionarioRequestDTO {
    @NotBlank
    private String nome;
    @NotNull
    @Min(18)
    private Integer idade;
    @NotBlank
    private String setor;
    @NotBlank
    private String cargo;
}
