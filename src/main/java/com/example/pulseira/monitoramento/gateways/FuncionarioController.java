package com.example.pulseira.monitoramento.gateways;

import com.example.pulseira.monitoramento.dtos.FuncionarioRequestDTO;
import com.example.pulseira.monitoramento.dtos.FuncionarioResponseDTO;
import com.example.pulseira.monitoramento.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public Page<FuncionarioResponseDTO> list(
            @RequestParam(defaultValue="0") int page,
            @RequestParam(defaultValue="10") int size
    ) {
        return service.findAll(PageRequest.of(page, size, Sort.by("nome")));
    }

    @PostMapping
    public FuncionarioResponseDTO add(@RequestBody FuncionarioRequestDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public FuncionarioResponseDTO update(@PathVariable Long id, @RequestBody FuncionarioRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

