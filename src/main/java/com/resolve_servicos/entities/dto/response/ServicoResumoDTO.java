package com.resolve_servicos.entities.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.resolve_servicos.enums.EnumStatusServico;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class ServicoResumoDTO {

    private Long servicoId;
    private String clienteNome;
    private String tipoServicoNome;
    private EnumStatusServico status;
    private String statusDescricao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAgendamento;
    private LocalTime horarioAgendamento;
    private String enderecoCliente;
    private BigDecimal valorOrcamento;
    private Boolean pago;

    public ServicoResumoDTO() {
    }

    public Long getServicoId() {
        return servicoId;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getTipoServicoNome() {
        return tipoServicoNome;
    }

    public void setTipoServicoNome(String tipoServicoNome) {
        this.tipoServicoNome = tipoServicoNome;
    }

    public EnumStatusServico getStatus() {
        return status;
    }

    public void setStatus(EnumStatusServico status) {
        this.status = status;
    }

    public String getStatusDescricao() {
        return statusDescricao;
    }

    public void setStatusDescricao(String statusDescricao) {
        this.statusDescricao = statusDescricao;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public LocalTime getHorarioAgendamento() {
        return horarioAgendamento;
    }

    public void setHorarioAgendamento(LocalTime horarioAgendamento) {
        this.horarioAgendamento = horarioAgendamento;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public BigDecimal getValorOrcamento() {
        return valorOrcamento;
    }

    public void setValorOrcamento(BigDecimal valorOrcamento) {
        this.valorOrcamento = valorOrcamento;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }
}
