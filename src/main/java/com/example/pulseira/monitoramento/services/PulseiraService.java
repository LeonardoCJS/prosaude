package com.example.pulseira.monitoramento.services;

import com.example.pulseira.monitoramento.domains.Funcionario;
import com.example.pulseira.monitoramento.domains.Pulseira;
import com.example.pulseira.monitoramento.dtos.*;
import com.example.pulseira.monitoramento.exception.ResourceNotFoundException;
import com.example.pulseira.monitoramento.gateways.PulseiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PulseiraService {

    @Autowired
    private PulseiraRepository repository;

    @Autowired
    private FuncionarioService funcionarioService;

    public PulseiraResponseDTO save(PulseiraRequestDTO dto) {
        Funcionario funcionario = funcionarioService.getById(dto.getFuncionarioId());
        Pulseira entity = Pulseira.builder()
                .numeroPulseira(dto.getNumeroPulseira())
                .funcionario(funcionario)
                .build();
        return toResponseDTO(repository.save(entity));
    }

    public PulseiraResponseDTO update(Long id, PulseiraRequestDTO dto) {
        Pulseira entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pulseira não encontrada"));
        entity.setNumeroPulseira(dto.getNumeroPulseira());
        entity.setFuncionario(funcionarioService.getById(dto.getFuncionarioId()));
        return toResponseDTO(repository.save(entity));
    }

    public PulseiraResponseDTO getById(Long id) {
        Pulseira p = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pulseira não encontrada"));
        return toResponseDTO(p);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private PulseiraResponseDTO toResponseDTO(Pulseira p) {
        PulseiraResponseDTO dto = new PulseiraResponseDTO();
        dto.setIdPulseira(p.getIdPulseira());
        dto.setNumeroPulseira(p.getNumeroPulseira());
        if (p.getFuncionario() != null) {
            dto.setFuncionarioId(p.getFuncionario().getId());
            dto.setFuncionarioNome(p.getFuncionario().getNome());
        }
        return dto;
    }
}
