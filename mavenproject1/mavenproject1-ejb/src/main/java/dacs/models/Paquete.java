/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dacs.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "Paquete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paquete.findAll", query = "SELECT p FROM Paquete p"),
    @NamedQuery(name = "Paquete.findByIdPaquete", query = "SELECT p FROM Paquete p WHERE p.idPaquete = :idPaquete"),
    @NamedQuery(name = "Paquete.findByCantidad", query = "SELECT p FROM Paquete p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Paquete.findByNombre", query = "SELECT p FROM Paquete p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Paquete.findByFechaInicio", query = "SELECT p FROM Paquete p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Paquete.findByFechaFin", query = "SELECT p FROM Paquete p WHERE p.fechaFin = :fechaFin"),
    @NamedQuery(name = "Paquete.findByPrecio", query = "SELECT p FROM Paquete p WHERE p.precio = :precio")})
public class Paquete implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPaquete")
    private Integer idPaquete;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Size(max = 20)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Precio")
    private float precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPaquete")
    private Collection<ReservaPaquete> reservaPaqueteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPaquete")
    private Collection<Evento> eventoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPaquete")
    private Collection<Transporte> transporteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPaquete")
    private Collection<Hotel> hotelCollection;

    public Paquete() {
    }

    public Paquete(Integer idPaquete) {
        this.idPaquete = idPaquete;
    }

    public Paquete(Integer idPaquete, Date fechaInicio, Date fechaFin, float precio) {
        this.idPaquete = idPaquete;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
    }

    public Integer getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(Integer idPaquete) {
        this.idPaquete = idPaquete;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @XmlTransient
    public Collection<ReservaPaquete> getReservaPaqueteCollection() {
        return reservaPaqueteCollection;
    }

    public void setReservaPaqueteCollection(Collection<ReservaPaquete> reservaPaqueteCollection) {
        this.reservaPaqueteCollection = reservaPaqueteCollection;
    }

    @XmlTransient
    public Collection<Evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<Evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
    }

    @XmlTransient
    public Collection<Transporte> getTransporteCollection() {
        return transporteCollection;
    }

    public void setTransporteCollection(Collection<Transporte> transporteCollection) {
        this.transporteCollection = transporteCollection;
    }

    @XmlTransient
    public Collection<Hotel> getHotelCollection() {
        return hotelCollection;
    }

    public void setHotelCollection(Collection<Hotel> hotelCollection) {
        this.hotelCollection = hotelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaquete != null ? idPaquete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paquete)) {
            return false;
        }
        Paquete other = (Paquete) object;
        if ((this.idPaquete == null && other.idPaquete != null) || (this.idPaquete != null && !this.idPaquete.equals(other.idPaquete))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dacs.models.Paquete[ idPaquete=" + idPaquete + " ]";
    }
    
}
