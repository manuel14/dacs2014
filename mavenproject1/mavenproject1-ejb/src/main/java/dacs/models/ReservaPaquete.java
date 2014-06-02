/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dacs.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "ReservaPaquete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservaPaquete.findAll", query = "SELECT r FROM ReservaPaquete r"),
    @NamedQuery(name = "ReservaPaquete.findByIdReservaPaquete", query = "SELECT r FROM ReservaPaquete r WHERE r.idReservaPaquete = :idReservaPaquete"),
    @NamedQuery(name = "ReservaPaquete.findByEstado", query = "SELECT r FROM ReservaPaquete r WHERE r.estado = :estado"),
    @NamedQuery(name = "ReservaPaquete.findByPrecioTotal", query = "SELECT r FROM ReservaPaquete r WHERE r.precioTotal = :precioTotal")})
public class ReservaPaquete implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idReservaPaquete")
    private Integer idReservaPaquete;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado")
    private String estado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precioTotal")
    private Float precioTotal;
    @JoinColumn(name = "idPaquete", referencedColumnName = "idPaquete")
    @ManyToOne(optional = false)
    private Paquete idPaquete;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReservaPaquete")
    private Collection<FormadePagoReserva> formadePagoReservaCollection;

    public ReservaPaquete() {
    }

    public ReservaPaquete(Integer idReservaPaquete) {
        this.idReservaPaquete = idReservaPaquete;
    }

    public ReservaPaquete(Integer idReservaPaquete, String estado) {
        this.idReservaPaquete = idReservaPaquete;
        this.estado = estado;
    }

    public Integer getIdReservaPaquete() {
        return idReservaPaquete;
    }

    public void setIdReservaPaquete(Integer idReservaPaquete) {
        this.idReservaPaquete = idReservaPaquete;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Paquete getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(Paquete idPaquete) {
        this.idPaquete = idPaquete;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @XmlTransient
    public Collection<FormadePagoReserva> getFormadePagoReservaCollection() {
        return formadePagoReservaCollection;
    }

    public void setFormadePagoReservaCollection(Collection<FormadePagoReserva> formadePagoReservaCollection) {
        this.formadePagoReservaCollection = formadePagoReservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReservaPaquete != null ? idReservaPaquete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaPaquete)) {
            return false;
        }
        ReservaPaquete other = (ReservaPaquete) object;
        if ((this.idReservaPaquete == null && other.idReservaPaquete != null) || (this.idReservaPaquete != null && !this.idReservaPaquete.equals(other.idReservaPaquete))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dacs.models.ReservaPaquete[ idReservaPaquete=" + idReservaPaquete + " ]";
    }
    
}
