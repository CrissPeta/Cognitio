package com.construcc.cognitio.Logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construcc.cognitio.Persistencia.Entidades.Tipocita;
import com.construcc.cognitio.Persistencia.repo.TipocitaRepo;


@Service
public class TipocitaServlmp implements TipocitaServ{

    @Autowired
    private TipocitaRepo tipocitaRepo;

    @Override
    public List<Tipocita> verTipocitas() {
        return tipocitaRepo.findAll();
    }

    @Override
    public Tipocita guardar(Tipocita tipocita) {
       return tipocitaRepo.saveAndFlush(tipocita);
    }

    @Override
    public void eliminar(Tipocita tipocita) {
        tipocitaRepo.delete(tipocita);
    }
    
}
