package com.example.pulseira.monitoramento.gateways;

import com.example.pulseira.monitoramento.domains.TempoSentado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TempoSentadoRepository extends JpaRepository<TempoSentado, Long> {
    TempoSentado findByFuncionarioId(Long funcionarioId);
}
