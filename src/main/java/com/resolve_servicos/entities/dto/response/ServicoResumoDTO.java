package com.resolve_servicos.entities.dto.response;

import com.resolve_servicos.enums.EnumStatusServico;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class ServicoResumoDTO {

    private Long servicoId;
    private Long clienteNome;
    private String tipoServicoNome;
    private EnumStatusServico status;
    private LocalDate dataAgendamento;
    private LocalTime horarioAgendamento;
    private String enderecoCliente;
    private BigDecimal valorOrcamento;
    private Boolean pago;
}
