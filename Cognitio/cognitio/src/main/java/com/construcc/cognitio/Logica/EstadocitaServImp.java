package com.construcc.cognitio.Logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construcc.cognitio.Persistencia.Entidades.Estadocita;
import com.construcc.cognitio.Persistencia.repo.EstadocitaRepo;


@Service
public class EstadocitaServImp implements EstadocitaServ{


    @Autowired
    private EstadocitaRepo estadocitaRepo;
    
    @Override
    public List<Estadocita> verEstadocitas() {
    return estadocitaRepo.findAll();
    }

    @Override
    public Estadocita guardar(Estadocita estadocita) {
      return estadocitaRepo.saveAndFlush(estadocita);
    }

    @Override
    public void eliminar(Estadocita estadocita) {
        estadocitaRepo.delete(estadocita);
    }
    
}
