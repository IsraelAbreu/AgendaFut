package com.agenda_fut.agendafut.service;

import com.agenda_fut.agendafut.dto.ClienteDTO;
import com.agenda_fut.agendafut.entity.Cliente;
import com.agenda_fut.agendafut.entity.Telefones;
import com.agenda_fut.agendafut.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente cliente){
        try{
            return clienteRepository.save(cliente);
        } catch (RuntimeException e){
            throw new RuntimeException("Ocorreu um erro ao cadastro o cliente"+ e.getCause());
        }
    }

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }
}
