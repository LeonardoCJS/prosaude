package com.example.pulseira.monitoramento.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@With
@Getter
@Entity
@Table(name = "pulseira")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Pulseira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPulseira;
    private Integer numeroPulseira;

    @OneToOne
    private Funcionario funcionario;
}
