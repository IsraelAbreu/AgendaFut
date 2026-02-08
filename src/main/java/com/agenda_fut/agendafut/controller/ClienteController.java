package com.agenda_fut.agendafut.controller;

import com.agenda_fut.agendafut.entity.Cliente;
import com.agenda_fut.agendafut.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente){
        return clienteService.salvar(cliente);
    }

    @GetMapping
    public List<Cliente> listarClientes(){
        return clienteService.listarClientes();
    }
}
