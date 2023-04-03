package com.construcc.cognitio.Logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construcc.cognitio.Persistencia.Entidades.Cliente;
import com.construcc.cognitio.Persistencia.repo.ClienteRepo;


@Service
public class ClienteServImp implements ClienteServ {

    @Autowired
    private ClienteRepo clienteRepo;
    @Override
    public List<Cliente> verClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return clienteRepo.saveAndFlush(cliente);
    }

    @Override
    public void eliminar(Cliente cliente) {
        clienteRepo.delete(cliente);
    }
    
}
