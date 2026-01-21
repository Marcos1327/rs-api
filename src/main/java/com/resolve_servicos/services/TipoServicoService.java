package com.resolve_servicos.services;

import com.resolve_servicos.entities.dto.request.TipoServicoRequestDTO;
import com.resolve_servicos.entities.dto.response.TipoServicoResponseDTO;
import com.resolve_servicos.entities.mapstructs.TipoServicoMapper;
import com.resolve_servicos.entities.model.TipoServico;
import com.resolve_servicos.exceptions.handlers.BusinessException;
import com.resolve_servicos.exceptions.handlers.ResourceNotFoundException;
import com.resolve_servicos.repositories.TipoServicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class TipoServicoService {

    private final TipoServicoRepository tipoServicoRepository;
    private final TipoServicoMapper tipoServicoMapper;

    public TipoServicoService(TipoServicoRepository tipoServicoRepository,  TipoServicoMapper tipoServicoMapper) {
        this.tipoServicoRepository = tipoServicoRepository;
        this.tipoServicoMapper = tipoServicoMapper;
    }

    public TipoServicoResponseDTO criar(TipoServicoRequestDTO tipoServicoRequestDTO) {
        if(tipoServicoRepository.existsByNomeTipoServicoIgnoreCaseAndAtivoTrue(tipoServicoRequestDTO.getNome())) {
            throw new BusinessException("Já existe um tipo de servico com este nome");
        }

        TipoServico tipoServico = tipoServicoMapper.toEntity(tipoServicoRequestDTO);
        tipoServico.setAtivo(true);
        tipoServico.setDataCriacao(LocalDate.now());
        tipoServico.setDataAtualizacao(LocalDate.now());

        TipoServico salvo = tipoServicoRepository.save(tipoServico);
        return tipoServicoMapper.toResponseDTO(salvo);
    }

    public TipoServicoResponseDTO atualizar(Long tipoServicoId, TipoServicoRequestDTO tipoServicoRequestDTO) {
        TipoServico tipoServico = tipoServicoRepository.findByTipoServicoIdAndAtivoTrue(tipoServicoId).orElseThrow(() -> new ResourceNotFoundException("Tipo de Serviço não encontrado"));

        if(tipoServicoRequestDTO.getNome() != null && !tipoServicoRequestDTO.getNome().equalsIgnoreCase(tipoServico.getNomeTipoServico())) {
            if(tipoServicoRepository.existsByNomeTipoServicoIgnoreCaseAndTipoServicoIdNotAndAtivoTrue(tipoServico.getNomeTipoServico(), tipoServicoId)) {
                throw new BusinessException("Já existe um tipo de serviço com este nome");
            }
        }

        if(tipoServicoRequestDTO.getNome() != null && !tipoServicoRequestDTO.getNome().isEmpty()){
            tipoServico.setNomeTipoServico(tipoServicoRequestDTO.getNome());
        }

        if(tipoServicoRequestDTO.getDescricao() != null && !tipoServicoRequestDTO.getDescricao().isEmpty()){
            tipoServico.setDescricao(tipoServicoRequestDTO.getDescricao());
        }

        TipoServico atualizado = tipoServicoRepository.save(tipoServico);
        return tipoServicoMapper.toResponseDTO(atualizado);
    }

    @Transactional(readOnly = true)
    public TipoServicoResponseDTO buscarPorId(Long tipoServicoId) {
        TipoServico tipoServico = tipoServicoRepository.findByTipoServicoIdAndAtivoTrue(tipoServicoId).orElseThrow(() -> new ResourceNotFoundException("Tipo de serviço não encontrado"));
        return tipoServicoMapper.toResponseDTO(tipoServico);
    }

    @Transactional(readOnly = true)
    public List<TipoServicoResponseDTO> listar() {
        List<TipoServico> tipoServicos = tipoServicoRepository.findByAtivoTrueOrderByNomeTipoServicoAsc();
        return tipoServicoMapper.toResponseDTOList(tipoServicos);
    }

    public void deletar(Long tipoServicoId) {
        TipoServico tipoServico = tipoServicoRepository.findByTipoServicoIdAndAtivoTrue(tipoServicoId).orElseThrow(() -> new ResourceNotFoundException("Tipo de serviço não encontrado"));
        tipoServico.setAtivo(false);
        tipoServico.setDataAtualizacao(LocalDate.now());
        tipoServicoRepository.save(tipoServico);
    }
}
