package com.resolve_servicos.entities.dto.response;

import java.math.BigDecimal;
import java.util.List;

public class DashboardRespondeDTO {
    private Integer servicosHoje;
    private Integer servicosSemana;
    private Integer servicosPendentes;
    private BigDecimal valorAReceber;
    private BigDecimal valorRecebidoMes;
    private List<ServicoResumoDTO> proximosAgendamentos;

    public DashboardRespondeDTO() {
    }

    public Integer getServicosHoje() {
        return servicosHoje;
    }

    public void setServicosHoje(Integer servicosHoje) {
        this.servicosHoje = servicosHoje;
    }

    public Integer getServicosSemana() {
        return servicosSemana;
    }

    public void setServicosSemana(Integer servicosSemana) {
        this.servicosSemana = servicosSemana;
    }

    public Integer getServicosPendentes() {
        return servicosPendentes;
    }

    public void setServicosPendentes(Integer servicosPendentes) {
        this.servicosPendentes = servicosPendentes;
    }

    public BigDecimal getValorAReceber() {
        return valorAReceber;
    }

    public void setValorAReceber(BigDecimal valorAReceber) {
        this.valorAReceber = valorAReceber;
    }

    public BigDecimal getValorRecebidoMes() {
        return valorRecebidoMes;
    }

    public void setValorRecebidoMes(BigDecimal valorRecebidoMes) {
        this.valorRecebidoMes = valorRecebidoMes;
    }

    public List<ServicoResumoDTO> getProximosAgendamentos() {
        return proximosAgendamentos;
    }

    public void setProximosAgendamentos(List<ServicoResumoDTO> proximosAgendamentos) {
        this.proximosAgendamentos = proximosAgendamentos;
    }
}
