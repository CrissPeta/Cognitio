package com.construcc.cognitio.Logica;

import java.util.List;

import com.construcc.cognitio.Persistencia.Entidades.Cita;

public interface CitaServ {
    public List<Cita> verCitas();
    public Cita guardar(Cita cita);
    public void eliminar(Cita cita);
}
