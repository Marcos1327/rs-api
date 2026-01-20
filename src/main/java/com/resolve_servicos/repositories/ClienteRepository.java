package com.resolve_servicos.repositories;

import com.resolve_servicos.entities.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
