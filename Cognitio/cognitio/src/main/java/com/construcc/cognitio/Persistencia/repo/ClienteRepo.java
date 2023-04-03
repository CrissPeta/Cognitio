package com.construcc.cognitio.Persistencia.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.construcc.cognitio.Persistencia.Entidades.Cliente;

public interface ClienteRepo extends  JpaRepository<Cliente, Integer>{
    
}
