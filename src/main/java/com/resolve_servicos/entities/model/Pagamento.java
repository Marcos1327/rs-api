package com.resolve_servicos.entities.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.resolve_servicos.enums.EnumFormaPagamento;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pagamentoId;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate  dataPagamento;
    @Column(nullable = false)
    private Boolean status = false;
    private String observacao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAtualizacao;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servico_id", nullable = false, unique = true)
    private Servico servico;
    @Enumerated(EnumType.STRING)
    private EnumFormaPagamento formaPagamento;
}
