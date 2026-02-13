package com.agenda_fut.agendafut.controller;

import com.agenda_fut.agendafut.entity.Aluguel;
import com.agenda_fut.agendafut.service.AluguelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alugueis")
@RequiredArgsConstructor
public class AluguelController {
    private final AluguelService aluguelService;

    @PostMapping
    public ResponseEntity<Aluguel> salvarAluguel(@RequestBody Aluguel aluguel){
        return ResponseEntity.ok(aluguelService.salvarHorario(aluguel));
    }
    @GetMapping
    public ResponseEntity<List<Aluguel>> exibirAlugueis(){
        return ResponseEntity.ok(aluguelService.consultarHorarioAlugados());
    }
}
