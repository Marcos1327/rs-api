package com.resolve_servicos.controller;

import com.resolve_servicos.entities.dto.request.ClienteRequestDTO;
import com.resolve_servicos.entities.dto.response.ClienteResponseDTO;
import com.resolve_servicos.entities.dto.response.ClienteResumoDTO;
import com.resolve_servicos.entities.model.Cliente;
import com.resolve_servicos.services.ClienteService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/create")
    public ResponseEntity<ClienteResponseDTO> criar(@RequestBody ClienteRequestDTO clienteRequestDTO){
        return ResponseEntity.ok(clienteService.criar(clienteRequestDTO));
    }

    @PatchMapping("atualizar/{clienteId}")
    public ResponseEntity<ClienteResponseDTO> atualizar(@PathVariable Long clienteId, @RequestBody ClienteRequestDTO clienteRequestDTO){
        return ResponseEntity.ok(clienteService.atualizar(clienteId, clienteRequestDTO));
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteResponseDTO> buscar(@PathVariable Long clienteId){
        return ResponseEntity.ok(clienteService.buscarPorId(clienteId));
    }

    @GetMapping()
    public ResponseEntity<List<ClienteResumoDTO>> listarTodos() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/buscar-por-nome")
    public ResponseEntity<List<ClienteResumoDTO>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(clienteService.buscarPorNome(nome));
    }

    @GetMapping("/buscar-com-servico/{clienteId}")
    public ResponseEntity<ClienteResponseDTO>  buscarComServico(@PathVariable Long clienteId){
        return ResponseEntity.ok(clienteService.buscarComServicos(clienteId));
    }

    @DeleteMapping("/delete/{clienteId}")
    public ResponseEntity<ClienteResponseDTO> delete(@PathVariable Long clienteId){
        clienteService.deletar(clienteId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/reativar/{clienteId}")
    public ResponseEntity<ClienteResponseDTO> reativar(@PathVariable Long clienteId){
        return ResponseEntity.ok(clienteService.reativar(clienteId));
    }
}
