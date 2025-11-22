package com.example.pulseira.monitoramento.gateways;

import com.example.pulseira.monitoramento.domains.Pulseira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PulseiraRepository extends JpaRepository<Pulseira, Long> {}
