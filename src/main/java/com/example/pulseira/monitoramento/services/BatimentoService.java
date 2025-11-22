package com.example.pulseira.monitoramento.services;

import com.example.pulseira.monitoramento.domains.Batimento;
import com.example.pulseira.monitoramento.domains.Funcionario;
import com.example.pulseira.monitoramento.dtos.BatimentoRequestDTO;
import com.example.pulseira.monitoramento.dtos.BatimentoResponseDTO;
import com.example.pulseira.monitoramento.gateways.BatimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;import java.time.LocalDateTime;

@Service
public class BatimentoService {

    @Autowired
    private BatimentoRepository repository;
    @Autowired
    private FuncionarioService funcionarioService;

    public BatimentoResponseDTO save(BatimentoRequestDTO dto) {
        Funcionario funcionario = funcionarioService.getById(dto.getFuncionarioId());
        Batimento batimento = Batimento.builder()
                .batimento(dto.getBatimento())
                .timestamp(LocalDateTime.now())
                .funcionario(funcionario)
                .build();
        return toResponseDTO(repository.save(batimento));
    }

    public Page<BatimentoResponseDTO> findByFuncionario(Long funcionarioId, Pageable pageable) {
        return repository.findByFuncionarioId(funcionarioId, pageable)
                .map(this::toResponseDTO);
    }

    private BatimentoResponseDTO toResponseDTO(Batimento b) {
        BatimentoResponseDTO dto = new BatimentoResponseDTO();
        dto.setId(b.getId());
        dto.setBatimento(b.getBatimento());
        dto.setTimestamp(b.getTimestamp());
        if (b.getFuncionario() != null) {
            dto.setFuncionarioId(b.getFuncionario().getId());
            dto.setFuncionarioNome(b.getFuncionario().getNome());
        }
        return dto;
    }
}