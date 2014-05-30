/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dacs.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    @NamedQuery(name = "ReservaPaquete.findByIdCliente", query = "SELECT r FROM ReservaPaquete r WHERE r.reservaPaquetePK.idCliente = :idCliente"),
    @NamedQuery(name = "ReservaPaquete.findByIdPaquete", query = "SELECT r FROM ReservaPaquete r WHERE r.reservaPaquetePK.idPaquete = :idPaquete"),
    @NamedQuery(name = "ReservaPaquete.findByEstado", query = "SELECT r FROM ReservaPaquete r WHERE r.estado = :estado"),
    @NamedQuery(name = "ReservaPaquete.findByPrecioTotal", query = "SELECT r FROM ReservaPaquete r WHERE r.precioTotal = :precioTotal")})
public class ReservaPaquete implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReservaPaquetePK reservaPaquetePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado")
    private String estado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precioTotal")
    private Float precioTotal;
    @JoinColumn(name = "idPaquete", referencedColumnName = "idPaquete", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paquete paquete;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservaPaquete")
    private Collection<FormadePagoReserva> formadePagoReservaCollection;

    public ReservaPaquete() {
    }

    public ReservaPaquete(ReservaPaquetePK reservaPaquetePK) {
        this.reservaPaquetePK = reservaPaquetePK;
    }

    public ReservaPaquete(ReservaPaquetePK reservaPaquetePK, String estado) {
        this.reservaPaquetePK = reservaPaquetePK;
        this.estado = estado;
    }

    public ReservaPaquete(int idCliente, int idPaquete) {
        this.reservaPaquetePK = new ReservaPaquetePK(idCliente, idPaquete);
    }

    public ReservaPaquetePK getReservaPaquetePK() {
        return reservaPaquetePK;
    }

    public void setReservaPaquetePK(ReservaPaquetePK reservaPaquetePK) {
        this.reservaPaquetePK = reservaPaquetePK;
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

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        hash += (reservaPaquetePK != null ? reservaPaquetePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaPaquete)) {
            return false;
        }
        ReservaPaquete other = (ReservaPaquete) object;
        if ((this.reservaPaquetePK == null && other.reservaPaquetePK != null) || (this.reservaPaquetePK != null && !this.reservaPaquetePK.equals(other.reservaPaquetePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.ReservaPaquete[ reservaPaquetePK=" + reservaPaquetePK + " ]";
    }
    
}
