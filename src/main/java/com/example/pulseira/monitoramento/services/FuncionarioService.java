package com.example.pulseira.monitoramento.services;

import com.example.pulseira.monitoramento.domains.*;
import com.example.pulseira.monitoramento.dtos.*;
import com.example.pulseira.monitoramento.exception.ResourceNotFoundException;
import com.example.pulseira.monitoramento.gateways.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Page<FuncionarioResponseDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(this::toResponseDTO);
    }

    public FuncionarioResponseDTO save(FuncionarioRequestDTO dto) {
        Funcionario f = Funcionario.builder()
                .nome(dto.getNome())
                .idade(dto.getIdade())
                .setor(dto.getSetor())
                .cargo(dto.getCargo())
                .build();
        return toResponseDTO(repository.save(f));
    }

    public FuncionarioResponseDTO update(Long id, FuncionarioRequestDTO dto) {
        Funcionario f = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionario não encontrado"));
        f.setNome(dto.getNome());
        f.setIdade(dto.getIdade());
        f.setSetor(dto.getSetor());
        f.setCargo(dto.getCargo());
        return toResponseDTO(repository.save(f));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Funcionario getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionario não encontrado"));
    }

    private FuncionarioResponseDTO toResponseDTO(Funcionario f) {
        FuncionarioResponseDTO dto = new FuncionarioResponseDTO();
        dto.setId(f.getId());
        dto.setNome(f.getNome());
        dto.setIdade(f.getIdade());
        dto.setSetor(f.getSetor());
        dto.setCargo(f.getCargo());
        return dto;
    }
}
