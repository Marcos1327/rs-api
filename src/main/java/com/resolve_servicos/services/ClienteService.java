package com.resolve_servicos.services;

import com.resolve_servicos.entities.dto.request.ClienteRequestDTO;
import com.resolve_servicos.entities.dto.response.ClienteResponseDTO;
import com.resolve_servicos.entities.mapstructs.ClienteMapper;
import com.resolve_servicos.entities.model.Cliente;
import com.resolve_servicos.exceptions.handlers.ResourceNotFoundException;
import com.resolve_servicos.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public ClienteResponseDTO criar(ClienteRequestDTO clienteRequestDTO) {

        if(clienteRepository.existsByTelefoneAndAtivoTrue(clienteRequestDTO.getTelefone())) {
            throw new ResourceNotFoundException("Já existe um cliente com este telefone");
        }
        Cliente cliente = clienteMapper.toEntity(clienteRequestDTO);
        cliente.setAtivo(true);
        cliente.setDataCriacao(LocalDate.now());
        cliente.setDataAtualizacao(LocalDate.now());

        Cliente clientesalvo = clienteRepository.save(cliente);

        return clienteMapper.toResponseDTO(clientesalvo);
    }

    public void deletar(Long clienteId){
        Cliente cliente = clienteRepository.findByClienteIdAndAtivoTrue(clienteId).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        cliente.setAtivo(false);
        clienteRepository.save(cliente);
    }
}
