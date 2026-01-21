package com.resolve_servicos.repositories;

import com.resolve_servicos.entities.model.TipoServico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TipoServicoRepository extends JpaRepository<TipoServico, Long> {

    List<TipoServico> findByAtivoTrue();

    Optional<TipoServico> findByTipoServicoIdAndAtivoTrue(Long tipoServicoId);

    Optional<TipoServico> findByNomeTipoServicoIgnoreCaseAndAtivoTrue(String nomeTipoServico);

    boolean existsByNomeTipoServicoIgnoreCaseAndAtivoTrue(String nomeTipoServico);

    boolean existsByNomeTipoServicoIgnoreCaseAndTipoServicoIdNotAndAtivoTrue(String nomeTipoServico, Long tipoServicoId);

    List<TipoServico> findByAtivoTrueOrderByNomeTipoServicoAsc();
}
