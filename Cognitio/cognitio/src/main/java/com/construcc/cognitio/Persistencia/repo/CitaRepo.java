package com.construcc.cognitio.Persistencia.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.construcc.cognitio.Persistencia.Entidades.Cita;

public interface CitaRepo extends  JpaRepository<Cita, Integer>{
    
}
