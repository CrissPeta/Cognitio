package com.construcc.cognitio.Logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construcc.cognitio.Persistencia.Entidades.Usuario;
import com.construcc.cognitio.Persistencia.repo.UsuarioRepo;

@Service
public class UsuarioServImp implements UsuarioServ {


    @Autowired
    private UsuarioRepo usuarioRepo;

    @Override
    public List<Usuario> verUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioRepo.saveAndFlush(usuario);
    }

    @Override
    public void eliminar(Usuario usuario) {
        usuarioRepo.delete(usuario);
    }
    
}
