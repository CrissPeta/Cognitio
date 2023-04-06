/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.construcc.cognitio.Persistencia.Entidades;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 *
 * @author clsuarezp
 */
@Entity
@Table(name = "cita")
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcita")
    private Integer idcita;
    @Basic(optional = false)
    @Column(name = "fecha")
    private Timestamp fecha;
    @Column(name = "observacion")
    private String observacion;

    @ManyToOne()
    @JoinColumn(name = "cliente_idcliente")
    private Cliente clienteidCliente;

    @JoinColumn(name = "estadocita_idestadocita")
    @ManyToOne()
    private Estadocita estadoCitaidestadoCita;

    @JoinColumn(name = "tipocita_idtipocita")
    @ManyToOne()
    private Tipocita tipoCitaidtipoCita;

    @JoinColumn(name = "usuario_idusuario")
    @ManyToOne()
    private Usuario usuarioIdusuario;

    public Cita() {
    }

    public Cita(Integer idcita) {
        this.idcita = idcita;
    }

    public Cita(Integer idcita, Timestamp fecha) {
        this.idcita = idcita;
        this.fecha = fecha;
    }

    public Cita(Timestamp fecha, String observacion, Cliente clienteidCliente, Estadocita estadoCitaidestadoCita,
            Tipocita tipoCitaidtipoCita, Usuario usuarioIdusuario) {
        this.fecha = fecha;
        this.observacion = observacion;
        this.clienteidCliente = clienteidCliente;
        this.estadoCitaidestadoCita = estadoCitaidestadoCita;
        this.tipoCitaidtipoCita = tipoCitaidtipoCita;
        this.usuarioIdusuario = usuarioIdusuario;
    }

    public Integer getIdcita() {
        return idcita;
    }

    public void setIdcita(Integer idcita) {
        this.idcita = idcita;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Cliente getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(Cliente clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    public Estadocita getEstadoCitaidestadoCita() {
        return estadoCitaidestadoCita;
    }

    public void setEstadoCitaidestadoCita(Estadocita estadoCitaidestadoCita) {
        this.estadoCitaidestadoCita = estadoCitaidestadoCita;
    }

    public Tipocita getTipoCitaidtipoCita() {
        return tipoCitaidtipoCita;
    }

    public void setTipoCitaidtipoCita(Tipocita tipoCitaidtipoCita) {
        this.tipoCitaidtipoCita = tipoCitaidtipoCita;
    }

    public Usuario getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(Usuario usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcita != null ? idcita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.idcita == null && other.idcita != null)
                || (this.idcita != null && !this.idcita.equals(other.idcita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Cita[ idcita=" + idcita + " ]";
    }

}
