package com.resolve_servicos.entities.dto.response;

import com.resolve_servicos.enums.EnumFormaPagamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PagamentoRealizadoDTO {

    private Long pagamentoId;
    private String clienteNome;
    private LocalDate dataPagamento;
    private EnumFormaPagamento formaPagamento;
    private String formaPagamentoDescricao;
    private BigDecimal valor;

    public PagamentoRealizadoDTO() {
    }

    public Long getPagamentoId() {
        return pagamentoId;
    }

    public void setPagamentoId(Long pagamentoId) {
        this.pagamentoId = pagamentoId;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public EnumFormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(EnumFormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getFormaPagamentoDescricao() {
        return formaPagamentoDescricao;
    }

    public void setFormaPagamentoDescricao(String formaPagamentoDescricao) {
        this.formaPagamentoDescricao = formaPagamentoDescricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
