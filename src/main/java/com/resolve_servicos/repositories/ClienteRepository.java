package com.resolve_servicos.repositories;

import com.resolve_servicos.entities.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByAtivoTrue();

    List<Cliente> findByNomeContainingIgnoreCaseAndAtivoTrue(String nome);

    boolean existsByTelefoneAndAtivoTrue(String telefone);

    Optional<Cliente> findByClienteIdAndAtivoTrue(Long clienteId);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Cliente c " +
            "WHERE c.telefone = :telefone AND c.ativo = true AND c.clienteId != :clienteId")
    boolean existsByTelefoneAndClienteIdNotAndAtivoTrue(@Param("telefone") String telefone, @Param("clienteId") Long clienteId);

    @Query("SELECT c from Cliente c left join fetch c.servicos where c.clienteId =:clienteId and c.ativo = true")
    Optional<Cliente> findByClienteIdWithServicos(Long clienteId);
}
