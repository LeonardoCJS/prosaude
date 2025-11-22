package com.example.pulseira.monitoramento.gateways;

import com.example.pulseira.monitoramento.dtos.TempoSentadoRequestDTO;
import com.example.pulseira.monitoramento.dtos.TempoSentadoResponseDTO;
import com.example.pulseira.monitoramento.services.TempoSentadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/temposentado")
public class TempoSentadoController {

    @Autowired
    private TempoSentadoService service;

    @PostMapping
    public TempoSentadoResponseDTO salvarOuAtualizar(@RequestBody TempoSentadoRequestDTO dto) {
        return service.salvarOuAtualizar(dto);
    }

    @GetMapping("/{funcionarioId}")
    public TempoSentadoResponseDTO consultar(@PathVariable Long funcionarioId) {
        return service.consultar(funcionarioId);
    }
}
