package com.agenda_fut.agendafut.service;

import com.agenda_fut.agendafut.entity.Aluguel;
import com.agenda_fut.agendafut.repository.AluguelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AluguelService {
    private final AluguelRepository aluguelRepository;

    public Aluguel salvarHorario(Aluguel aluguel){
        //definindo um valor fixo por hora
        aluguel.setValor(BigDecimal.valueOf(120));

        return aluguelRepository.save(aluguel);
    }

    public List<Aluguel> consultarHorarioAlugados(){
        return aluguelRepository.findAll();
    }
}
