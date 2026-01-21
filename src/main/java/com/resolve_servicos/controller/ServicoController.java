package com.resolve_servicos.controller;

import com.resolve_servicos.entities.dto.request.ServicoRequestDTO;
import com.resolve_servicos.entities.dto.response.ServicoResponseDTO;
import com.resolve_servicos.services.ServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/servicos")
public class ServicoController {

    private final ServicoService  servicoService;

    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }


    @PostMapping("/create")
    public ResponseEntity<ServicoResponseDTO> criar(@RequestBody ServicoRequestDTO servicoRequestDTO){
        return ResponseEntity.ok(servicoService.criar(servicoRequestDTO));
    }
}
