/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.construcc.cognitio.Persistencia.Entidades;

import java.io.Serializable;
/* import java.util.List; */
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/* import javax.persistence.OneToMany; */
import javax.persistence.Table;

/**
 *
 * @author clsuarezp
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "celular")
    private String celular;
    @Column(name = "direccion")
    private String direccion;
    /* @OneToMany(mappedBy = "usuarioIdusuario")
    private List<Item> itemList; */
    @JoinColumn(name = "estadousuario_idestadousuario")
    @ManyToOne(optional = false)
    private Estadousuario estadoUsuarioidestadoUsuario;
    @JoinColumn(name = "rolusuario_idrolusuario")
    @ManyToOne(optional = false)
    private Rolusuario rolUsuarioidrolUsuario;
    /* @OneToMany(mappedBy = "usuarioIdusuario")
    private List<Cita> citaList; */

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(Integer idusuario, String nombre) {
        this.idusuario = idusuario;
        this.nombre = nombre;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /* public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    } */

    public Estadousuario getEstadoUsuarioidestadoUsuario() {
        return estadoUsuarioidestadoUsuario;
    }

    public void setEstadoUsuarioidestadoUsuario(Estadousuario estadoUsuarioidestadoUsuario) {
        this.estadoUsuarioidestadoUsuario = estadoUsuarioidestadoUsuario;
    }

    public Rolusuario getRolUsuarioidrolUsuario() {
        return rolUsuarioidrolUsuario;
    }

    public void setRolUsuarioidrolUsuario(Rolusuario rolUsuarioidrolUsuario) {
        this.rolUsuarioidrolUsuario = rolUsuarioidrolUsuario;
    }

    /* public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    } */

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Usuario[ idusuario=" + idusuario + " ]";
    }
    
}
