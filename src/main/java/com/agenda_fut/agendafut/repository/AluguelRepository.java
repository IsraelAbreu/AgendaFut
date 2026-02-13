package com.agenda_fut.agendafut.repository;


import com.agenda_fut.agendafut.entity.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
    boolean existsByDataAndHoraInicioLessThanAndHoraFimGreaterThan(
            LocalDate data,
            LocalTime horaFim,
            LocalTime horaInicio
    );
}
