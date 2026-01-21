package com.resolve_servicos.entities.mapstructs;

import com.resolve_servicos.entities.dto.request.PagamentoRequestDTO;
import com.resolve_servicos.entities.dto.response.PagamentoPendenteDTO;
import com.resolve_servicos.entities.dto.response.PagamentoRealizadoDTO;
import com.resolve_servicos.entities.dto.response.PagamentoResponseDTO;
import com.resolve_servicos.entities.model.Pagamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface PagamentoMapper {

    @Mapping(target = "servico", ignore = true)
    Pagamento toEntity(PagamentoRequestDTO pagamentoRequestDTO);

    @Mapping(target = "servicoId", source = "servico.servicoId")
    @Mapping(target = "formaPagamentoDescricao", expression = "java(pagamento.getFormaPagamento().getDescricao())")
    PagamentoResponseDTO toResponseDTO(Pagamento pagamento);

    @Mapping(target = "servicoId", source = "servico.servicoId")
    @Mapping(target = "clienteNome", source = "servico.cliente.nome")
    @Mapping(target = "tipoServico", source = "servico.tipoServico.nomeTipoServico")
    @Mapping(target = "dataServico", source = "servico.dataExecucao")
    PagamentoPendenteDTO toPendenteDTO(Pagamento pagamento);

    @Mapping(target = "pagamentoId", source = "pagamentoId")
    @Mapping(target = "clienteNome", source = "servico.cliente.nome")
    @Mapping(target = "formaPagamentoDescricao", expression = "java(pagamento.getFormaPagamento().getDescricao())")
    PagamentoRealizadoDTO toRealizadoDTO(Pagamento pagamento);

    List<PagamentoResponseDTO> toResponseDTOList(List<Pagamento> pagamento);

    List<PagamentoPendenteDTO> toPendenteDTOList(List<Pagamento> pagamento);

    List<PagamentoRealizadoDTO> toRealizadoDTOList(List<Pagamento> pagamento);



}
