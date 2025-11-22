package com.example.pulseira.monitoramento.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TempoSentadoResponseDTO {
    private String funcionarioNome;
    private Integer tempoMinutos;
    private Long pulsseiraId;
    private Long funcionarioId;
}
