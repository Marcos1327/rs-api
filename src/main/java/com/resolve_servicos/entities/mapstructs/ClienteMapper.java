package com.resolve_servicos.entities.mapstructs;

import com.resolve_servicos.entities.dto.request.ClienteRequestDTO;
import com.resolve_servicos.entities.dto.response.ClienteResponseDTO;
import com.resolve_servicos.entities.dto.response.ClienteResumoDTO;
import com.resolve_servicos.entities.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface ClienteMapper {

    Cliente toEntity(ClienteRequestDTO clienteRequestDTO);

    void updateEntityFromDTO(ClienteRequestDTO clienteRequestDTO, @MappingTarget Cliente cliente);

    @Mapping(target = "totalServicos", expression = "java(cliente.getServicos() != null ? cliente.getServicos().size() : 0)")
    ClienteResponseDTO toResponseDTO(Cliente cliente);

    @Mapping(target = "totalServicos", expression = "java(cliente.getServicos() != null ? cliente.getServicos().size() : 0)")
    ClienteResumoDTO toResumoDTO(Cliente cliente);

    List<ClienteResponseDTO> toResponseDTOList(List<Cliente> clientes);

    List<ClienteResumoDTO> toResumoDTOList(List<Cliente> clientes);
}
