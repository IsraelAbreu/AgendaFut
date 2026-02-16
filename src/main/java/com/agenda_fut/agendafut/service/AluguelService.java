package com.agenda_fut.agendafut.service;

import com.agenda_fut.agendafut.entity.Aluguel;
import com.agenda_fut.agendafut.exceptions.ConflictException;
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

        try{
            if (aluguel.getHoraFim().isBefore(aluguel.getHoraInicio()) || aluguel.getHoraFim().equals(aluguel.getHoraInicio())){
                throw new ConflictException("O horário de fim deve ser maior que o horário de inicio");
            }

            boolean horarioOcupado = verificaSeHorarioOcupado(aluguel);

            if (horarioOcupado){
                throw new ConflictException("O Horário escolhido já está ocupado");
            }

            //definindo um valor fixo por hora
            aluguel.setValor(BigDecimal.valueOf(120));

            return aluguelRepository.save(aluguel);
        }catch (RuntimeException e){
            throw new ConflictException("Ocorreu um erro ao finalizar o aluguel! " + e.getMessage());
        }

    }

    public List<Aluguel> consultarHorarioAlugados(){
        return aluguelRepository.findAll();
    }

    public boolean verificaSeHorarioOcupado(Aluguel aluguel){
        return aluguelRepository.existsByDataAndHoraInicioLessThanAndHoraFimGreaterThan(
                    aluguel.getData(),
                    aluguel.getHoraInicio(),
                    aluguel.getHoraFim()
        );
    }

}
