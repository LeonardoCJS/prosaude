package com.example.pulseira.monitoramento.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PulseiraResponseDTO {
    private Long idPulseira;
    private Integer numeroPulseira;
    private Long funcionarioId;
    private String funcionarioNome;
}
