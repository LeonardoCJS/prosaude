package com.example.pulseira.monitoramento.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BatimentoResponseDTO {
    private Long id;
    private Integer batimento;
    private LocalDateTime timestamp;
    private Long pulsseiraId;
    private Long funcionarioId;
    private String funcionarioNome;
}
