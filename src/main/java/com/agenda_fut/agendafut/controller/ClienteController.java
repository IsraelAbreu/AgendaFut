package com.agenda_fut.agendafut.controller;

import com.agenda_fut.agendafut.dto.ClienteDTO;
import com.agenda_fut.agendafut.entity.Cliente;
import com.agenda_fut.agendafut.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.salvarCliente(cliente));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> exibirClientes(){
        return ResponseEntity.ok(clienteService.listarClientes());
    }
}
