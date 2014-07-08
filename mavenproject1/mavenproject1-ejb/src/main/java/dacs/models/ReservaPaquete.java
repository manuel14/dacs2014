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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "reservapaquete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservaPaquete.findAll", query = "SELECT r FROM ReservaPaquete r"),
    @NamedQuery(name = "ReservaPaquete.findByIdreservapaquete", query = "SELECT r FROM ReservaPaquete r WHERE r.idreservapaquete = :idreservapaquete"),
    @NamedQuery(name = "ReservaPaquete.findByEstado", query = "SELECT r FROM ReservaPaquete r WHERE r.estado = :estado"),
    @NamedQuery(name = "ReservaPaquete.findByPreciototal", query = "SELECT r FROM ReservaPaquete r WHERE r.preciototal = :preciototal")})
public class ReservaPaquete implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreservapaquete")
    private Integer idreservapaquete;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado")
    private String estado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preciototal")
    private Float preciototal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idreservapaquete")
    private Collection<FormadePagoReserva> formadePagoReservaCollection;
    @JoinColumn(name = "idpaquete", referencedColumnName = "idpaquete")
    @ManyToOne(optional = false)
    private Paquete idpaquete;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente idcliente;

    public ReservaPaquete() {
    }

    public ReservaPaquete(Integer idreservapaquete) {
        this.idreservapaquete = idreservapaquete;
    }

    public ReservaPaquete(Integer idreservapaquete, String estado) {
        this.idreservapaquete = idreservapaquete;
        this.estado = estado;
    }

    public Integer getIdreservapaquete() {
        return idreservapaquete;
    }

    public void setIdreservapaquete(Integer idreservapaquete) {
        this.idreservapaquete = idreservapaquete;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Float getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(Float preciototal) {
        this.preciototal = preciototal;
    }

    @XmlTransient
    public Collection<FormadePagoReserva> getFormadePagoReservaCollection() {
        return formadePagoReservaCollection;
    }

    public void setFormadePagoReservaCollection(Collection<FormadePagoReserva> formadePagoReservaCollection) {
        this.formadePagoReservaCollection = formadePagoReservaCollection;
    }

    public Paquete getIdpaquete() {
        return idpaquete;
    }

    public void setIdpaquete(Paquete idpaquete) {
        this.idpaquete = idpaquete;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreservapaquete != null ? idreservapaquete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaPaquete)) {
            return false;
        }
        ReservaPaquete other = (ReservaPaquete) object;
        if ((this.idreservapaquete == null && other.idreservapaquete != null) || (this.idreservapaquete != null && !this.idreservapaquete.equals(other.idreservapaquete))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dacs.models.ReservaPaquete[ idreservapaquete=" + idreservapaquete + " ]";
    }
    
}
