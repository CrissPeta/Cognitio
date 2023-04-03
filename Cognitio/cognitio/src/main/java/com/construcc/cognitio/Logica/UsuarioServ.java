package com.construcc.cognitio.Logica;

import java.util.List;

import com.construcc.cognitio.Persistencia.Entidades.Usuario;

public interface UsuarioServ {
    public List<Usuario> verUsuarios();
    public Usuario guardar(Usuario usuario);
    public void eliminar(Usuario usuario);
}
