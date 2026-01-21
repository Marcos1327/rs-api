package com.resolve_servicos;

import com.resolve_servicos.entities.dto.request.ServicoRequestDTO;
import com.resolve_servicos.entities.dto.response.ClienteResponseDTO;
import com.resolve_servicos.services.ClienteService;
import com.resolve_servicos.services.ServicoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class ResolveServicosApplicationTests {

    @Autowired
    private ServicoService servicoService;

    @MockitoBean
    private ClienteService clienteService;

    @Test
    void contextLoads() {
    }

    @Test
    void deveCriarServicoBuscandoClientePorId() {
        // Arrange
        ServicoRequestDTO request = new ServicoRequestDTO();
        request.setClienteId(1L);

        ClienteResponseDTO clienteMock = new ClienteResponseDTO();
        clienteMock.setClienteId(1L);
        clienteMock.setNome("Cliente Teste");

        Mockito.when(clienteService.buscarPorId(clienteMock.getClienteId()))
                .thenReturn(clienteMock);

        // Act
        servicoService.criar(request);

        // Assert
        Mockito.verify(clienteService, Mockito.times(1))
                .buscarPorId(1L);
    }

}
