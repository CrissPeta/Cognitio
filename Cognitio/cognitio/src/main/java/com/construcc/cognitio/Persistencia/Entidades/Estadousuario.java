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
@Table(name = "estadousuario")
@NamedQueries({
    @NamedQuery(name = "Estadousuario.findAll", query = "SELECT e FROM Estadousuario e"),
    @NamedQuery(name = "Estadousuario.findByIdestadoUsuario", query = "SELECT e FROM Estadousuario e WHERE e.idestadoUsuario = :idestadoUsuario"),
    @NamedQuery(name = "Estadousuario.findByNombre", query = "SELECT e FROM Estadousuario e WHERE e.nombre = :nombre")})
public class Estadousuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestadousuario")
    private Integer idestadoUsuario;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoUsuarioidestadoUsuario", fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;

    public Estadousuario() {
    }

    public Estadousuario(Integer idestadoUsuario) {
        this.idestadoUsuario = idestadoUsuario;
    }

    public Estadousuario(Integer idestadoUsuario, String nombre) {
        this.idestadoUsuario = idestadoUsuario;
        this.nombre = nombre;
    }

    public Integer getIdestadoUsuario() {
        return idestadoUsuario;
    }

    public void setIdestadoUsuario(Integer idestadoUsuario) {
        this.idestadoUsuario = idestadoUsuario;
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
        hash += (idestadoUsuario != null ? idestadoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadousuario)) {
            return false;
        }
        Estadousuario other = (Estadousuario) object;
        if ((this.idestadoUsuario == null && other.idestadoUsuario != null) || (this.idestadoUsuario != null && !this.idestadoUsuario.equals(other.idestadoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Estadousuario[ idestadoUsuario=" + idestadoUsuario + " ]";
    }
    
}
