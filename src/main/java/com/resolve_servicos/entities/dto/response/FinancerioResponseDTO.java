package com.resolve_servicos.entities.dto.response;

import java.math.BigDecimal;
import java.util.List;

public class FinancerioResponseDTO {

    private BigDecimal totalAReceber;
    private BigDecimal recebidoMes;
    private BigDecimal pendente;
    private List<PagamentoPendenteDTO> pagamentosPendentes;
    private List<PagamentoRealizadoDTO> ultimosRecebimentos;

    public FinancerioResponseDTO() {
    }

    public BigDecimal getTotalAReceber() {
        return totalAReceber;
    }

    public void setTotalAReceber(BigDecimal totalAReceber) {
        this.totalAReceber = totalAReceber;
    }

    public BigDecimal getRecebidoMes() {
        return recebidoMes;
    }

    public void setRecebidoMes(BigDecimal recebidoMes) {
        this.recebidoMes = recebidoMes;
    }

    public BigDecimal getPendente() {
        return pendente;
    }

    public void setPendente(BigDecimal pendente) {
        this.pendente = pendente;
    }

    public List<PagamentoPendenteDTO> getPagamentosPendentes() {
        return pagamentosPendentes;
    }

    public void setPagamentosPendentes(List<PagamentoPendenteDTO> pagamentosPendentes) {
        this.pagamentosPendentes = pagamentosPendentes;
    }

    public List<PagamentoRealizadoDTO> getUltimosRecebimentos() {
        return ultimosRecebimentos;
    }

    public void setUltimosRecebimentos(List<PagamentoRealizadoDTO> ultimosRecebimentos) {
        this.ultimosRecebimentos = ultimosRecebimentos;
    }
}
