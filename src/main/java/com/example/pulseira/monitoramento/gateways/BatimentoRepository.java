package com.example.pulseira.monitoramento.gateways;

import com.example.pulseira.monitoramento.domains.Batimento;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
public interface BatimentoRepository extends JpaRepository<Batimento, Long> {
    Page<Batimento> findByFuncionarioId(Long funcionarioId, Pageable pageable);
}
