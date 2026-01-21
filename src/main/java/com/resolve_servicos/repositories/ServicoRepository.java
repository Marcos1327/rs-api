package com.resolve_servicos.repositories;

import com.resolve_servicos.entities.model.Servico;
import com.resolve_servicos.enums.EnumStatusServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

    List<Servico> findByClienteOrderByDataAgendamentoDesc(Long clienteId);

    List<Servico> findByStatusServicoOrderByDataAgendamentoAsc(EnumStatusServico status);

    List<Servico> findByDataAgendamentoOrderByHorarioAgendamentoAsc(LocalDate data);

    List<Servico> findByDataAgendamentoBetweenOrderByDataAgendamentoAscHorarioAgendamentoAsc(LocalDate dataInicio, LocalDate dataFim);

    @Query("SELECT s FROM Servico s WHERE s.dataAgendamento = :data ORDER BY s.horarioAgendamento ASC")
    List<Servico> findServicosDodia(@Param("data") LocalDate data);

    @Query("SELECT s FROM Servico s WHERE s.dataAgendamento BETWEEN :inicio AND :fim " +
            "ORDER BY s.dataAgendamento ASC, s.horarioAgendamento ASC")
    List<Servico> findServicosDaSemana(@Param("inicio") LocalDate inicio, @Param("fim") LocalDate fim);

    @Query("SELECT s FROM Servico s WHERE s.statusServico NOT IN ('CONCLUIDO', 'CANCELADO') " +
            "ORDER BY s.dataAgendamento ASC")
    List<Servico> findServicosPendentes();

    @Query("SELECT s FROM Servico s WHERE s.dataAgendamento >= :hoje AND s.statusServico = 'AGENDADO' " +
            "ORDER BY s.dataAgendamento ASC, s.horarioAgendamento ASC")
    List<Servico> findProximosAgendamentos(@Param("hoje") LocalDate hoje);

    @Query("SELECT s FROM Servico s LEFT JOIN s.pagamento p " +
            "WHERE s.statusServico = 'CONCLUIDO' AND (p IS NULL OR p.pago = false) " +
            "ORDER BY s.dataExecucao DESC")
    List<Servico> findServicosComPagamentoPendente();

    @Query("SELECT s FROM Servico s " +
            "LEFT JOIN FETCH s.cliente " +
            "LEFT JOIN FETCH s.tipoServico " +
            "LEFT JOIN FETCH s.pagamento " +
            "WHERE s.servicoId = :servicoId")
    Optional<Servico> findByIdWithRelations(@Param("servicoId") Long servicoId);

    long countByStatusServico(EnumStatusServico status);

    long countByDataAgendamento(LocalDate data);

    long countByDataAgendamentoBetween(LocalDate dataAgendamento, LocalDate dataExecucao);

    List<Servico> findByTipoServicoOrderByDataAgendamentoDesc(Long tipoServicoId);

    @Query("SELECT s FROM Servico s WHERE s.cliente.clienteId = :clienteId AND s.statusServico = 'CONCLUIDO' " +
            "ORDER BY s.dataExecucao DESC")
    List<Servico> findServicosConcluidosPorCliente(@Param("clienteId") Long clienteId);
}
