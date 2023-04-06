package com.construcc.cognitio.Logica;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.construcc.cognitio.Persistencia.Entidades.Cita;
import com.construcc.cognitio.Persistencia.repo.CitaRepo;


@Service
public class CitaSerImp implements CitaServ{

    @Autowired
    private CitaRepo citaRepo;

    @Override
    @Transactional (readOnly = true)
    public List<Cita> verCitas() {
        return citaRepo.findAll();
    }

    @Override
    @Transactional 
    public Cita guardar(Cita cita) {
        return citaRepo.saveAndFlush(cita);
    }

    @Override
    @Transactional
    public void eliminar(Cita cita) {
        citaRepo.delete(cita);
    }
/* 
    @Override
    @Transactional (readOnly = true)
    public Cita encontrarCita(Cita cita){
       return citaRepo.findById(cita.getIdcita()).orElse(null);
    } */
    
}
