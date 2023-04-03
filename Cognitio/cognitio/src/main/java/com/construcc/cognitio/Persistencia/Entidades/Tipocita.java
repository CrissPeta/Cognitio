/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.construcc.cognitio.Persistencia.Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author clsuarezp
 */
@Entity
@Table(name = "tipocita")
public class Tipocita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipocita")
    private Integer idtipoCita;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "tipoCitaidtipoCita")
    private List<Cita> citaList;

    public Tipocita() {
    }

    public Tipocita(Integer idtipoCita) {
        this.idtipoCita = idtipoCita;
    }

    public Tipocita(Integer idtipoCita, String nombre) {
        this.idtipoCita = idtipoCita;
        this.nombre = nombre;
    }

    public Integer getIdtipoCita() {
        return idtipoCita;
    }

    public void setIdtipoCita(Integer idtipoCita) {
        this.idtipoCita = idtipoCita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoCita != null ? idtipoCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipocita)) {
            return false;
        }
        Tipocita other = (Tipocita) object;
        if ((this.idtipoCita == null && other.idtipoCita != null) || (this.idtipoCita != null && !this.idtipoCita.equals(other.idtipoCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Tipocita[ idtipoCita=" + idtipoCita + " ]";
    }
    
}
