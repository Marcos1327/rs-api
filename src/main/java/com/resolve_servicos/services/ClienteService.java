package com.resolve_servicos.services;

import com.resolve_servicos.entities.dto.request.ClienteRequestDTO;
import com.resolve_servicos.entities.dto.response.ClienteResponseDTO;
import com.resolve_servicos.entities.dto.response.ClienteResumoDTO;
import com.resolve_servicos.entities.mapstructs.ClienteMapper;
import com.resolve_servicos.entities.model.Cliente;
import com.resolve_servicos.exceptions.handlers.BusinessException;
import com.resolve_servicos.exceptions.handlers.ResourceNotFoundException;
import com.resolve_servicos.repositories.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

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
            throw new BusinessException("Já existe um cliente com este telefone");
        }
        Cliente cliente = clienteMapper.toEntity(clienteRequestDTO);
        cliente.setAtivo(true);
        cliente.setDataCriacao(LocalDate.now());
        cliente.setDataAtualizacao(LocalDate.now());

        Cliente clientesalvo = clienteRepository.save(cliente);

        return clienteMapper.toResponseDTO(clientesalvo);
    }

    public ClienteResponseDTO atualizar(Long clienteId, ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = clienteRepository.findByClienteIdAndAtivoTrue(clienteId).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        if(clienteRepository.existsByTelefoneAndClienteIdNotAndAtivoTrue(clienteRequestDTO.getTelefone(), clienteId)) {
            throw new BusinessException("Já existe um cliente com este telefone");
        }

        if(clienteRequestDTO.getNome() != null && !clienteRequestDTO.getNome().isEmpty()) {
            cliente.setNome(clienteRequestDTO.getNome());
        }

        if(clienteRequestDTO.getTelefone() != null && !clienteRequestDTO.getTelefone().isEmpty()) {
            cliente.setTelefone(clienteRequestDTO.getTelefone());
        }

        if(clienteRequestDTO.getEndereco() != null && !clienteRequestDTO.getEndereco().isEmpty()) {
            cliente.setEndereco(clienteRequestDTO.getEndereco());
        }

        if(clienteRequestDTO.getBairro() != null && !clienteRequestDTO.getBairro().isEmpty()) {
            cliente.setBairro(clienteRequestDTO.getBairro());
        }

        if(clienteRequestDTO.getCidade() != null && !clienteRequestDTO.getCidade().isEmpty()) {
            cliente.setCidade(clienteRequestDTO.getCidade());
        }

        if(clienteRequestDTO.getEstado() != null && !clienteRequestDTO.getEstado().isEmpty()) {
            cliente.setEstado(clienteRequestDTO.getEstado());
        }

        if(clienteRequestDTO.getCep() != null && !clienteRequestDTO.getCep().isEmpty()) {
            cliente.setCep(clienteRequestDTO.getCep());
        }

        if(clienteRequestDTO.getObservacao() != null && !clienteRequestDTO.getObservacao().isEmpty()) {
            cliente.setObservacao(clienteRequestDTO.getObservacao());
        }

        Cliente clienteAtualizado = clienteRepository.save(cliente);

        return clienteMapper.toResponseDTO(clienteAtualizado);
    }

    @Transactional(readOnly = true)
    public ClienteResponseDTO buscarPorId(Long clienteId) {
        Cliente cliente = clienteRepository.findByClienteIdAndAtivoTrue(clienteId).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        return clienteMapper.toResponseDTO(cliente);
    }

    @Transactional(readOnly = true)
    public List<ClienteResumoDTO> listarTodos() {
        List<Cliente> clientes = clienteRepository.findByAtivoTrue();
        return clienteMapper.toResumoDTOList(clientes);
    }

    public List<ClienteResumoDTO> buscarPorNome(String nome) {
        List<Cliente> clientes = clienteRepository.findByNomeContainingIgnoreCaseAndAtivoTrue(nome);
        return clienteMapper.toResumoDTOList(clientes);
    }

    /* Método inutil por enquanto*/
    public ClienteResponseDTO buscarComServicos(Long clienteId) {
        Cliente cliente = clienteRepository.findByClienteIdWithServicos(clienteId).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        return clienteMapper.toResponseDTO(cliente);
    }

    public void deletar(Long clienteId){
        Cliente cliente = clienteRepository.findByClienteIdAndAtivoTrue(clienteId).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        cliente.setAtivo(false);
        clienteRepository.save(cliente);
    }

    public ClienteResponseDTO reativar(Long clienteId){
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        cliente.setAtivo(true);
        Cliente clienteReativado = clienteRepository.save(cliente);
        return clienteMapper.toResponseDTO(clienteReativado);
    }
}
