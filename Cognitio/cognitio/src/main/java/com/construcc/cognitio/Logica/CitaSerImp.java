package com.construcc.cognitio.Logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construcc.cognitio.Persistencia.Entidades.Cita;
import com.construcc.cognitio.Persistencia.repo.CitaRepo;


@Service
public class CitaSerImp implements CitaServ{

    @Autowired
    private CitaRepo citaRepo;

    @Override
    public List<Cita> verCitas() {
        return citaRepo.findAll();
    }

    @Override
    public Cita guardar(Cita cita) {
        return citaRepo.saveAndFlush(cita);
    }

    @Override
    public void eliminar(Cita cita) {
        citaRepo.delete(cita);
    }
    
}
