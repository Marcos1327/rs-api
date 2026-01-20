package com.resolve_servicos.controller;

import com.resolve_servicos.entities.dto.request.ClienteRequestDTO;
import com.resolve_servicos.entities.dto.response.ClienteResponseDTO;
import com.resolve_servicos.entities.model.Cliente;
import com.resolve_servicos.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/create")
    public ResponseEntity<ClienteResponseDTO> create(@RequestBody ClienteRequestDTO clienteRequestDTO){
        return ResponseEntity.ok(clienteService.criar(clienteRequestDTO));
    }

    @DeleteMapping("/delete/{clienteId}")
    public ResponseEntity<ClienteResponseDTO> delete(@PathVariable Long clienteId){
        clienteService.deletar(clienteId);
        return ResponseEntity.noContent().build();
    }
}
