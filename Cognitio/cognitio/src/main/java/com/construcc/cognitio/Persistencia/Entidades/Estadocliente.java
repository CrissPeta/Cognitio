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
@Table(name = "estadocliente")
@NamedQueries({
    @NamedQuery(name = "Estadocliente.findAll", query = "SELECT e FROM Estadocliente e"),
    @NamedQuery(name = "Estadocliente.findByIdestadoCliente", query = "SELECT e FROM Estadocliente e WHERE e.idestadoCliente = :idestadoCliente"),
    @NamedQuery(name = "Estadocliente.findByNombre", query = "SELECT e FROM Estadocliente e WHERE e.nombre = :nombre")})
public class Estadocliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestadocliente")
    private Integer idestadoCliente;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoClienteidestadoCliente", fetch = FetchType.LAZY)
    private List<Cliente> clienteList;

    public Estadocliente() {
    }

    public Estadocliente(Integer idestadoCliente) {
        this.idestadoCliente = idestadoCliente;
    }

    public Estadocliente(Integer idestadoCliente, String nombre) {
        this.idestadoCliente = idestadoCliente;
        this.nombre = nombre;
    }

    public Integer getIdestadoCliente() {
        return idestadoCliente;
    }

    public void setIdestadoCliente(Integer idestadoCliente) {
        this.idestadoCliente = idestadoCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestadoCliente != null ? idestadoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadocliente)) {
            return false;
        }
        Estadocliente other = (Estadocliente) object;
        if ((this.idestadoCliente == null && other.idestadoCliente != null) || (this.idestadoCliente != null && !this.idestadoCliente.equals(other.idestadoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Estadocliente[ idestadoCliente=" + idestadoCliente + " ]";
    }
    
}
