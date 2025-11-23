package com.example.pulseira.monitoramento.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class PulseiraResponseDTO {
    private Long idPulseira;
    private Integer numeroPulseira;
    private Long funcionarioId;
    private String funcionarioNome;
}