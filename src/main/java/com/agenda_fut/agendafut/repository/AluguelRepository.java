package com.agenda_fut.agendafut.repository;


import com.agenda_fut.agendafut.entity.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
    @Query("""
    SELECT a
    FROM Aluguel a
    WHERE a.data = :data
    AND a.horaInicio < :horaFim
    AND a.horaFim > :horaInicio
""")
    List<Aluguel> buscarConflitos(
            @Param("data") LocalDate data,
            @Param("horaInicio") LocalTime horaInicio,
            @Param("horaFim") LocalTime horaFim
    );
}
