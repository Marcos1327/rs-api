package com.resolve_servicos.entities.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.resolve_servicos.enums.EnumStatusServico;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tb_servicos")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long servicoId;
    private String descricao;
    private String observacao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAgendamento;
    private LocalTime horarioAgendamento;
    @Column(precision = 10, scale = 2)
    private BigDecimal valorOrcamento;
    @Column(precision = 10, scale = 2)
    private BigDecimal valorFinal;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAtualizacao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id",  nullable = false)
    private Cliente cliente;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnumStatusServico statusServico = EnumStatusServico.SOLICITADO;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_servico_id", nullable = false)
    private TipoServico tipoServico;
    @OneToOne(mappedBy = "servico", cascade = CascadeType.ALL, orphanRemoval = true)
    private Pagamento pagamento;

    public Servico() {
    }

    public Long getServicoId() {
        return servicoId;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EnumStatusServico getStatusServico() {
        return statusServico;
    }

    public void setStatusServico(EnumStatusServico statusServico) {
        this.statusServico = statusServico;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
