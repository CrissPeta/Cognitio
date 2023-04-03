package com.construcc.cognitio.Logica;

import java.util.List;

import com.construcc.cognitio.Persistencia.Entidades.Cliente;

public interface  ClienteServ{
    public List<Cliente> verClientes();
    public Cliente guardar(Cliente cliente);
    public void eliminar(Cliente cliente);
}
