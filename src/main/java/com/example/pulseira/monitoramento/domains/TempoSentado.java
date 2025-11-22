package com.example.pulseira.monitoramento.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@With
@Getter
@Entity
@Table(name = "tempo_sentado")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class TempoSentado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer tempoMinutos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pulseira")
    @ToString.Exclude
    private Pulseira pulseira;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_funcionario")
    @ToString.Exclude
    private Funcionario funcionario;
}
