package com.resolve_servicos.entities.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.resolve_servicos.enums.EnumFormaPagamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class PagamentoRequestDTO {

    private Long servicoId;
    private BigDecimal valor;
    private EnumFormaPagamento formaPagamento;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPagamento;
    private Boolean pago;
    private String observaocao;
}
