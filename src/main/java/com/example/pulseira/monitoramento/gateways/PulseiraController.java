package com.example.pulseira.monitoramento.gateways;

import com.example.pulseira.monitoramento.dtos.PulseiraRequestDTO;
import com.example.pulseira.monitoramento.dtos.PulseiraResponseDTO;
import com.example.pulseira.monitoramento.services.PulseiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pulseiras")
public class PulseiraController {

    @Autowired
    private PulseiraService service;

    @PostMapping
    public PulseiraResponseDTO add(@RequestBody PulseiraRequestDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public PulseiraResponseDTO update(@PathVariable Long id, @RequestBody PulseiraRequestDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping("/{id}")
    public PulseiraResponseDTO consultar(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}