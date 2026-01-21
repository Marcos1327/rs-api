package com.resolve_servicos.entities.mapstructs;

import com.resolve_servicos.entities.dto.request.TipoServicoRequestDTO;
import com.resolve_servicos.entities.dto.response.TipoServicoResponseDTO;
import com.resolve_servicos.entities.model.TipoServico;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface TipoServicoMapper {

    TipoServico toEntity(TipoServicoRequestDTO tipoServicoRequestDTO);

    TipoServicoResponseDTO toResponseDTO(TipoServico tipoServico);

    List<TipoServicoResponseDTO> toResponseDTOList(List<TipoServico> tipoServico);
}
