package com.resolve_servicos.entities.dto.response;

import java.math.BigDecimal;
import java.util.List;

public class FinancerioResponseDTO {

    private BigDecimal totalAReceber;
    private BigDecimal recebidoMes;
    private BigDecimal pendente;
    private List<PagamentoPendenteDTO> pagamentosPendentes;
    private List<PagamentoRealizadoDTO> ultimosRecebimentos;

}
