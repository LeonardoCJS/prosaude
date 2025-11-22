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
public class PulseiraRequestDTO {
    @NotNull
    private Integer numeroPulseira;
    @NotNull
    private Long funcionarioId;
}
