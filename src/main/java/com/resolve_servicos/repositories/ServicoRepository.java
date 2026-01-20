package com.resolve_servicos.repositories;

import com.resolve_servicos.entities.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
