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
@Table(name = "estadoitem")
@NamedQueries({
    @NamedQuery(name = "Estadoitem.findAll", query = "SELECT e FROM Estadoitem e"),
    @NamedQuery(name = "Estadoitem.findByIdestadoItem", query = "SELECT e FROM Estadoitem e WHERE e.idestadoItem = :idestadoItem"),
    @NamedQuery(name = "Estadoitem.findByNombre", query = "SELECT e FROM Estadoitem e WHERE e.nombre = :nombre")})
public class Estadoitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestadoItem")
    private Integer idestadoItem;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoItemidestadoItem", fetch = FetchType.LAZY)
    private List<Item> itemList;

    public Estadoitem() {
    }

    public Estadoitem(Integer idestadoItem) {
        this.idestadoItem = idestadoItem;
    }

    public Estadoitem(Integer idestadoItem, String nombre) {
        this.idestadoItem = idestadoItem;
        this.nombre = nombre;
    }

    public Integer getIdestadoItem() {
        return idestadoItem;
    }

    public void setIdestadoItem(Integer idestadoItem) {
        this.idestadoItem = idestadoItem;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestadoItem != null ? idestadoItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Estadoitem)) {
            return false;
        }
        Estadoitem other = (Estadoitem) object;
        if ((this.idestadoItem == null && other.idestadoItem != null) || (this.idestadoItem != null && !this.idestadoItem.equals(other.idestadoItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Estadoitem[ idestadoItem=" + idestadoItem + " ]";
    }
    
}
