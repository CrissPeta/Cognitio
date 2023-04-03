package com.construcc.cognitio.Logica;

import java.util.List;

import com.construcc.cognitio.Persistencia.Entidades.Tipocita;

public interface TipocitaServ {
    public List<Tipocita> verTipocitas();
    public Tipocita guardar(Tipocita tipocita);
    public void eliminar(Tipocita tipocita);
}
