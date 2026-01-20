package com.resolve_servicos.repositories;

import com.resolve_servicos.entities.model.TipoServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoServicoRepository extends JpaRepository<TipoServico, Long> {
}
