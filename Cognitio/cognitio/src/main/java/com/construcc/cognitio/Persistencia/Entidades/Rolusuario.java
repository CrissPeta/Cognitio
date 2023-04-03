/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.construcc.cognitio.Persistencia.Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author clsuarezp
 */
@Entity
@Table(name = "rolusuario")
@NamedQueries({
    @NamedQuery(name = "Rolusuario.findAll", query = "SELECT r FROM Rolusuario r"),
    @NamedQuery(name = "Rolusuario.findByIdrolUsuario", query = "SELECT r FROM Rolusuario r WHERE r.idrolUsuario = :idrolUsuario"),
    @NamedQuery(name = "Rolusuario.findByNombre", query = "SELECT r FROM Rolusuario r WHERE r.nombre = :nombre")})
public class Rolusuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrolusuario")
    private Integer idrolUsuario;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolUsuarioidrolUsuario", fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;

    public Rolusuario() {
    }

    public Rolusuario(Integer idrolUsuario) {
        this.idrolUsuario = idrolUsuario;
    }

    public Rolusuario(Integer idrolUsuario, String nombre) {
        this.idrolUsuario = idrolUsuario;
        this.nombre = nombre;
    }

    public Integer getIdrolUsuario() {
        return idrolUsuario;
    }

    public void setIdrolUsuario(Integer idrolUsuario) {
        this.idrolUsuario = idrolUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrolUsuario != null ? idrolUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rolusuario)) {
            return false;
        }
        Rolusuario other = (Rolusuario) object;
        if ((this.idrolUsuario == null && other.idrolUsuario != null) || (this.idrolUsuario != null && !this.idrolUsuario.equals(other.idrolUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Rolusuario[ idrolUsuario=" + idrolUsuario + " ]";
    }
    
}
