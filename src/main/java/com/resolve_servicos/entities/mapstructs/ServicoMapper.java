package com.resolve_servicos.entities.mapstructs;

import com.resolve_servicos.entities.dto.request.ServicoRequestDTO;
import com.resolve_servicos.entities.dto.response.ServicoResponseDTO;
import com.resolve_servicos.entities.dto.response.ServicoResumoDTO;
import com.resolve_servicos.entities.model.Servico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ClienteMapper.class, TipoServicoMapper.class, PagamentoMapper.class}
)
public interface ServicoMapper {

    @Mapping(target = "statusServico", expression = "java(servicoRequestDTO.getStatus())")
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "tipoServico", ignore = true)
    @Mapping(target = "pagamento", ignore = true)
    Servico toEntity(ServicoRequestDTO servicoRequestDTO);

    @Mapping(target = "statusDescricao", expression = "java(servico.getStatusServico().getDescricao())")
    @Mapping(target = "status", expression = "java(servico.getStatusServico())")
    @Mapping(target = "cliente", source = "cliente")
    @Mapping(target = "tipoServicoResponseDTO", source = "tipoServico")
    @Mapping(target = "pagamento", source = "pagamento")
    ServicoResponseDTO toResponseDTO(Servico servico);

    @Mapping(target = "clienteNome", source = "cliente.nome")
    @Mapping(target = "tipoServicoNome", source = "tipoServico.nomeTipoServico")
    @Mapping(target = "statusDescricao", expression = "java(servico.getStatusServico().getDescricao())")
    @Mapping(target = "enderecoCliente", source = "cliente.endereco")
    @Mapping(target = "pago", expression = "java(servico.getPagamento() != null && servico.getPagamento().getPago())")
    ServicoResumoDTO toResumoDTO(Servico servico);

    List<ServicoResponseDTO> toResponseDTOList(List<Servico> servicos);

    List<ServicoResumoDTO> toResumoDTOList(List<Servico> servicos);
}
