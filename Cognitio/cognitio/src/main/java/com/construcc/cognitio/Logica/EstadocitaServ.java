package com.construcc.cognitio.Logica;

import java.util.List;

import com.construcc.cognitio.Persistencia.Entidades.Estadocita;

public interface EstadocitaServ {
    public List<Estadocita> verEstadocitas();
    public Estadocita guardar(Estadocita estadocita);
    public void eliminar(Estadocita Estadocita);
}
