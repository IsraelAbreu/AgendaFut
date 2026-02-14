package com.agenda_fut.agendafut.repository;

import com.agenda_fut.agendafut.entity.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);

    Optional<Cliente> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
