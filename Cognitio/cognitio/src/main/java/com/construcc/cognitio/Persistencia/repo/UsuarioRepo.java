package com.construcc.cognitio.Persistencia.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.construcc.cognitio.Persistencia.Entidades.Usuario;

public interface UsuarioRepo extends  JpaRepository<Usuario, Integer>{
   
}
