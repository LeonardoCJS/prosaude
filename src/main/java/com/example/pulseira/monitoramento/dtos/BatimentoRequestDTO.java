package com.example.pulseira.monitoramento.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatimentoRequestDTO {
    @NotNull
    private Integer batimento;

    @NotNull(message = "Pulseira ID é obrigatorio")
    private Long pulsseiraId;

    @NotNull(message = "Funcionario ID é obrigatorio")
    private Long funcionarioId;
}
