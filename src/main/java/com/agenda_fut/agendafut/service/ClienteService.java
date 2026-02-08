package com.agenda_fut.agendafut.service;

import com.agenda_fut.agendafut.entity.Cliente;
import com.agenda_fut.agendafut.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(Long idCliente){
        return clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
}
