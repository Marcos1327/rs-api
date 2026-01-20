package com.resolve_servicos.entities.dto.response;

import com.resolve_servicos.enums.EnumFormaPagamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PagamentoResponseDTO {

    private Long pagamentoId;
    private Long servicoId;
    private BigDecimal valor;
    private EnumFormaPagamento formaPagamento;
    private String formaPagamentoDescricao;
    private LocalDate dataPagamento;
    private Boolean pago;
    private String observacao;
    private LocalDate dataCriacao;
    private LocalDate dataAtualizacao;

    public PagamentoResponseDTO() {
    }

    public Long getPagamentoId() {
        return pagamentoId;
    }

    public void setPagamentoId(Long pagamentoId) {
        this.pagamentoId = pagamentoId;
    }

    public Long getServicoId() {
        return servicoId;
    }

    public void setServicoId(Long servicoId) {
        this.servicoId = servicoId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
