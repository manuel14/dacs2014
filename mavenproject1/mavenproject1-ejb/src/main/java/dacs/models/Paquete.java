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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "paquete" , schema = "test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paquete.findAll", query = "SELECT p FROM Paquete p"),
    @NamedQuery(name = "Paquete.findByIdpaquete", query = "SELECT p FROM Paquete p WHERE p.idpaquete = :idpaquete"),
    @NamedQuery(name = "Paquete.findByCantidad", query = "SELECT p FROM Paquete p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Paquete.findByOrigen", query = "SELECT p FROM Paquete p WHERE p.origen = :origen"),
    @NamedQuery(name = "Paquete.findByDestino", query = "SELECT p FROM Paquete p WHERE p.destino = :destino"),
    @NamedQuery(name = "Paquete.findByNombre", query = "SELECT p FROM Paquete p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Paquete.findByFechainicio", query = "SELECT p FROM Paquete p WHERE p.fechainicio = :fechainicio"),
    @NamedQuery(name = "Paquete.findByFechafin", query = "SELECT p FROM Paquete p WHERE p.fechafin = :fechafin"),
    @NamedQuery(name = "Paquete.findByPrecio", query = "SELECT p FROM Paquete p WHERE p.precio = :precio")})
public class Paquete implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpaquete")
    private Integer idpaquete;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Size(max = 50)
    @Column(name = "origen")
    private String origen;
    @Size(max = 50)
    @Column(name = "destino")
    private String destino;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechafin")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @Basic(optional = false)
    
    @Column(name = "precio")
    private float precio;
    @JoinColumn(name = "idtransporte", referencedColumnName = "idtransporte")
    @ManyToOne(optional = false)
    private Transporte idtransporte;
    @JoinColumn(name = "idhotel", referencedColumnName = "idhotel")
    @ManyToOne(optional = false)
    private Hotel idhotel;
    @JoinColumn(name = "idevento", referencedColumnName = "idevento")
    @ManyToOne(optional = false)
    private Evento idevento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpaquete")
    private Collection<ReservaPaquete> reservaPaqueteCollection;

    public Paquete() {
    }

    public Paquete(Integer idpaquete) {
        this.idpaquete = idpaquete;
    }

    public Paquete(Integer idpaquete, Date fechainicio, Date fechafin, float precio) {
        this.idpaquete = idpaquete;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.precio = precio;
    }

    public Integer getIdpaquete() {
        return idpaquete;
    }

    public void setIdpaquete(Integer idpaquete) {
        this.idpaquete = idpaquete;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Transporte getIdtransporte() {
        return idtransporte;
    }

    public void setIdtransporte(Transporte idtransporte) {
        this.idtransporte = idtransporte;
    }

    public Hotel getIdhotel() {
        return idhotel;
    }

    public void setIdhotel(Hotel idhotel) {
        this.idhotel = idhotel;
    }

    public Evento getIdevento() {
        return idevento;
    }

    public void setIdevento(Evento idevento) {
        this.idevento = idevento;
    }

    @XmlTransient
    public Collection<ReservaPaquete> getReservaPaqueteCollection() {
        return reservaPaqueteCollection;
    }

    public void setReservaPaqueteCollection(Collection<ReservaPaquete> reservaPaqueteCollection) {
        this.reservaPaqueteCollection = reservaPaqueteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpaquete != null ? idpaquete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paquete)) {
            return false;
        }
        Paquete other = (Paquete) object;
        if ((this.idpaquete == null && other.idpaquete != null) || (this.idpaquete != null && !this.idpaquete.equals(other.idpaquete))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dacs.models.Paquete[ idpaquete=" + idpaquete + " ]";
    }
    
}
