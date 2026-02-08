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

    public Cliente localizaCliente(String email){
        return clienteRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public void deletaCliente(String email){
        clienteRepository.deleteByEmail(email);
    }
}
