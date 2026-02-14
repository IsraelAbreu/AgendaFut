package com.agenda_fut.agendafut.service;

import com.agenda_fut.agendafut.entity.Cliente;
import com.agenda_fut.agendafut.exceptions.ConflictException;
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
            verificaSeEmailJaCadastrado(cliente.getEmail()); //Se aqui for TRUE já estoura a ConflictException na função verificaSeEmailJaCadastrado + RuntimeException do Catch
            return clienteRepository.save(cliente);
        } catch (RuntimeException e){
            throw new RuntimeException("Erro ao finalizar o cadastro do cliente! " + e.getMessage());
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

    public boolean verificaSeEmailExiste(String email){
        return clienteRepository.existsByEmail(email);
    }

    public void verificaSeEmailJaCadastrado(String email){
        try {
            boolean clienteCadastrado = verificaSeEmailExiste(email);
            if (clienteCadastrado){
                throw new ConflictException("Este e-mail já está cadastrado");
            }
        } catch (ConflictException e){
            throw new ConflictException("Este e-mail já está cadastrado");
        }
    }
}
