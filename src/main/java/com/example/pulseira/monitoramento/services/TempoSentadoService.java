package com.example.pulseira.monitoramento.services;

import com.example.pulseira.monitoramento.domains.Funcionario;
import com.example.pulseira.monitoramento.domains.Pulseira;
import com.example.pulseira.monitoramento.domains.TempoSentado;
import com.example.pulseira.monitoramento.dtos.TempoSentadoRequestDTO;
import com.example.pulseira.monitoramento.dtos.TempoSentadoResponseDTO;
import com.example.pulseira.monitoramento.exception.ResourceNotFoundException;
import com.example.pulseira.monitoramento.gateways.PulseiraRepository;
import com.example.pulseira.monitoramento.gateways.TempoSentadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TempoSentadoService {

    @Autowired
    private TempoSentadoRepository repository;

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private PulseiraRepository pulseiraRepository;

    public TempoSentadoResponseDTO salvarOuAtualizar(TempoSentadoRequestDTO dto) {
        Funcionario funcionario = funcionarioService.getById(dto.getFuncionarioId());
        Pulseira pulseira = pulseiraRepository.findById(dto.getPulsseiraId()).orElseThrow();
        TempoSentado entity = repository.findByFuncionarioId(funcionario.getId());
        if (entity == null) {
            entity = TempoSentado.builder()
                    .funcionario(funcionario)
                    .pulseira(pulseira)
                    .tempoMinutos(dto.getTempoMinutos())
                    .build();
        } else {
            entity.setTempoMinutos(dto.getTempoMinutos());
        }
        return toResponseDTO(repository.save(entity));
    }

    public TempoSentadoResponseDTO consultar(Long funcionarioId) {
        TempoSentado t = repository.findByFuncionarioId(funcionarioId);
        if (t == null) throw new ResourceNotFoundException("Tempo sentado não encontrado");
        return toResponseDTO(t);
    }

    private TempoSentadoResponseDTO toResponseDTO(TempoSentado t) {
        TempoSentadoResponseDTO dto = new TempoSentadoResponseDTO();
        dto.setFuncionarioId(t.getFuncionario().getId());
        dto.setFuncionarioNome(t.getFuncionario().getNome());
        dto.setTempoMinutos(t.getTempoMinutos());
        dto.setPulsseiraId(t.getPulseira().getIdPulseira());
        return dto;
    }
}