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
/* import javax.persistence.OneToMany; */
import javax.persistence.Table;

/**
 *
 * @author clsuarezp
 */
@Entity
@Table(name = "estadocita")
public class Estadocita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestadocita")
    private Integer idestadoCita;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    /* @OneToMany(mappedBy = "estadoCitaidestadoCita")
    private List<Cita> citaList; */

    public Estadocita() {
    }

    public Estadocita(Integer idestadoCita) {
        this.idestadoCita = idestadoCita;
    }

    public Estadocita(Integer idestadoCita, String nombre) {
        this.idestadoCita = idestadoCita;
        this.nombre = nombre;
    }

    public Integer getIdestadoCita() {
        return idestadoCita;
    }

    public void setIdestadoCita(Integer idestadoCita) {
        this.idestadoCita = idestadoCita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/* 
    public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    } */

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestadoCita != null ? idestadoCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Estadocita)) {
            return false;
        }
        Estadocita other = (Estadocita) object;
        if ((this.idestadoCita == null && other.idestadoCita != null) || (this.idestadoCita != null && !this.idestadoCita.equals(other.idestadoCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Estadocita[ idestadoCita=" + idestadoCita + " ]";
    }
    
}
