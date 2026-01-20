package com.resolve_servicos.repositories;

import com.resolve_servicos.entities.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByTelefoneAndAtivoTrue(String telefone);

    Optional<Cliente> findByClienteIdAndAtivoTrue(Long clienteId);

}
