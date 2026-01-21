package com.resolve_servicos.repositories;

import com.resolve_servicos.entities.model.Pagamento;
import com.resolve_servicos.enums.EnumFormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    // Buscar pagamento por serviço
    Optional<Pagamento> findByServico(Long servicoId);

    // Buscar pagamentos realizados (pagos)
    List<Pagamento> findByPagoTrueOrderByDataPagamentoDesc();
//
    // Buscar pagamentos pendentes
    List<Pagamento> findByPagoFalseOrderByDataPagamentoAsc();
//
    // Buscar pagamentos por forma de pagamento
    List<Pagamento> findByFormaPagamentoAndPagoTrueOrderByDataPagamentoDesc(EnumFormaPagamento formaPagamento);

    // Buscar pagamentos em um período
    List<Pagamento> findByDataPagamentoBetweenAndPagoTrueOrderByDataPagamentoDesc(
            LocalDate dataInicio,
            LocalDate dataFim
    );

    // Buscar últimos N pagamentos recebidos
    @Query("SELECT p FROM Pagamento p WHERE p.pago = true " +
            "ORDER BY p.dataPagamento DESC")
    List<Pagamento> findUltimosPagamentosRecebidos();

    // Calcular total recebido em um período
    @Query("SELECT COALESCE(SUM(p.valor), 0) FROM Pagamento p " +
            "WHERE p.pago = true AND p.dataPagamento BETWEEN :inicio AND :fim")
    BigDecimal calcularTotalRecebidoNoPeriodo(@Param("inicio") LocalDate inicio, @Param("fim") LocalDate fim);

    // Calcular total a receber (pagamentos pendentes)
    @Query("SELECT COALESCE(SUM(p.valor), 0) FROM Pagamento p WHERE p.pago = false")
    BigDecimal calcularTotalAReceber();

    // Calcular total recebido no mês
    @Query("SELECT COALESCE(SUM(p.valor), 0) FROM Pagamento p " +
            "WHERE p.pago = true AND YEAR(p.dataPagamento) = :ano AND MONTH(p.dataPagamento) = :mes")
    BigDecimal calcularTotalRecebidoNoMes(@Param("ano") int ano, @Param("mes") int mes);

    // Buscar pagamentos de um cliente específico
    @Query("SELECT p FROM Pagamento p " +
            "WHERE p.servico.cliente.clienteId = :clienteId " +
            "ORDER BY p.dataPagamento DESC")
    List<Pagamento> findByClienteId(@Param("clienteId") Long clienteId);

    // Verificar se serviço já tem pagamento
    boolean existsByServico(Long servicoId);

    // Contar pagamentos pendentes
    long countByPagoFalse();

    // Contar pagamentos realizados no mês
    @Query("SELECT COUNT(p) FROM Pagamento p " +
            "WHERE p.pago = true AND YEAR(p.dataPagamento) = :ano AND MONTH(p.dataPagamento) = :mes")
    long countPagamentosNoMes(@Param("ano") int ano, @Param("mes") int mes);
}
