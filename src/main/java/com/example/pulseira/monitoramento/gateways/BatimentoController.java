package com.example.pulseira.monitoramento.gateways;


import com.example.pulseira.monitoramento.dtos.BatimentoRequestDTO;
import com.example.pulseira.monitoramento.dtos.BatimentoResponseDTO;
import com.example.pulseira.monitoramento.services.BatimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
@RestController
@RequestMapping("/batimentos")
public class BatimentoController {

    @Autowired
    private BatimentoService service;

    @PostMapping
    public BatimentoResponseDTO add(@RequestBody BatimentoRequestDTO dto) {
        return service.save(dto);
    }

    @GetMapping
    public Page<BatimentoResponseDTO> listByFuncionario(
            @RequestParam Long funcionarioId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return service.findByFuncionario(funcionarioId, (Pageable) PageRequest.of(page, size, Sort.by("timestamp").descending()));
    }
}

