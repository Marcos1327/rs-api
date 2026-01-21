package com.resolve_servicos.services;

import com.resolve_servicos.entities.dto.request.ServicoRequestDTO;
import com.resolve_servicos.entities.dto.response.ClienteResponseDTO;
import com.resolve_servicos.entities.dto.response.ServicoResponseDTO;
import com.resolve_servicos.entities.dto.response.TipoServicoResponseDTO;
import com.resolve_servicos.entities.mapstructs.ClienteMapper;
import com.resolve_servicos.entities.mapstructs.ServicoMapper;
import com.resolve_servicos.entities.mapstructs.TipoServicoMapper;
import com.resolve_servicos.entities.model.Cliente;
import com.resolve_servicos.entities.model.Servico;
import com.resolve_servicos.entities.model.TipoServico;
import com.resolve_servicos.exceptions.handlers.ResourceNotFoundException;
import com.resolve_servicos.repositories.ClienteRepository;
import com.resolve_servicos.repositories.ServicoRepository;
import com.resolve_servicos.repositories.TipoServicoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;
    private final ClienteRepository clienteRepository;
    private final TipoServicoRepository tipoServicoRepository;
    private final ServicoMapper servicoMapper;

    public ServicoService(ServicoRepository servicoRepository, ServicoMapper servicoMapper, ClienteRepository clienteRepository,
                          TipoServicoRepository tipoServicoRepository ) {

        this.servicoRepository = servicoRepository;
        this.clienteRepository = clienteRepository;
        this.tipoServicoRepository = tipoServicoRepository;
        this.servicoMapper = servicoMapper;
    }

    public ServicoResponseDTO criar(ServicoRequestDTO servicoRequestDTO){
        Cliente cliente = clienteRepository.findByClienteIdAndAtivoTrue(servicoRequestDTO.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        // TODO: Criar servicoTipoServico
//        TipoServicoResponseDTO tipoServico =   tipoServicoService.buscarPorId(servicoRequestDTO.getTipoServicoId());

        Servico servico = servicoMapper.toEntity(servicoRequestDTO);

        servico.setCliente(cliente);
//        servico.setTipoServico(tipoServicoEntity);
        servico.setDataCriacao(LocalDate.now());
        servico.setDataAtualizacao(LocalDate.now());

        Servico salvo = servicoRepository.save(servico);

        Servico completo = servicoRepository.findByIdWithRelations(salvo.getServicoId()).
                orElseThrow(() -> new ResourceNotFoundException("Erro ao buscar serviço criado"));

        return servicoMapper.toResponseDTO(completo);

    }

}
