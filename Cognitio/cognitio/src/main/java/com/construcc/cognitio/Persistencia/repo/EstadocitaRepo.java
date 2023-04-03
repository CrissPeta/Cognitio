package com.construcc.cognitio.Persistencia.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.construcc.cognitio.Persistencia.Entidades.Estadocita;

public interface EstadocitaRepo extends  JpaRepository<Estadocita, Integer>{
    
}
