package com.resolve_servicos.entities.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.resolve_servicos.enums.EnumStatusServico;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class ServicoResponseDTO {

    private Long servicoId;
    private ClienteResumoDTO cliente;
    private TipoServicoResponseDTO tipoServicoResponseDTO;
    private EnumStatusServico status;
    private String statusDescricao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAgendamento;
    private LocalTime horarioAgendamento;
    private BigDecimal valorOrcamento;
    private BigDecimal valorFinal;
    private String descricao;
    private String observacao;
    private PagamentoResponseDTO pagamento;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAtualizacao;

    public ServicoResponseDTO() {
    }

    public Long getServicoId() {
        return servicoId;
    }

    public void setServicoId(Long servicoId) {
        this.servicoId = servicoId;
    }

    public ClienteResumoDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteResumoDTO cliente) {
        this.cliente = cliente;
    }

    public TipoServicoResponseDTO getTipoServicoResponseDTO() {
        return tipoServicoResponseDTO;
    }

    public void setTipoServicoResponseDTO(TipoServicoResponseDTO tipoServicoResponseDTO) {
        this.tipoServicoResponseDTO = tipoServicoResponseDTO;
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

    public BigDecimal getValorOrcamento() {
        return valorOrcamento;
    }

    public void setValorOrcamento(BigDecimal valorOrcamento) {
        this.valorOrcamento = valorOrcamento;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public PagamentoResponseDTO getPagamento() {
        return pagamento;
    }

    public void setPagamento(PagamentoResponseDTO pagamento) {
        this.pagamento = pagamento;
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
