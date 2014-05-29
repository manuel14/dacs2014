/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "Forma de Pago Reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormadePagoReserva.findAll", query = "SELECT f FROM FormadePagoReserva f"),
    @NamedQuery(name = "FormadePagoReserva.findByIdForma", query = "SELECT f FROM FormadePagoReserva f WHERE f.idForma = :idForma"),
    @NamedQuery(name = "FormadePagoReserva.findByTipoPago", query = "SELECT f FROM FormadePagoReserva f WHERE f.tipoPago = :tipoPago"),
    @NamedQuery(name = "FormadePagoReserva.findByDescripcion", query = "SELECT f FROM FormadePagoReserva f WHERE f.descripcion = :descripcion")})
public class FormadePagoReserva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idForma")
    private Integer idForma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipoPago")
    private String tipoPago;
    @Size(max = 20)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumns({
        @JoinColumn(name = "idCliente", referencedColumnName = "idCliente"),
        @JoinColumn(name = "idPaquete", referencedColumnName = "idPaquete")})
    @ManyToOne(optional = false)
    private ReservaPaquete reservaPaquete;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;

    public FormadePagoReserva() {
    }

    public FormadePagoReserva(Integer idForma) {
        this.idForma = idForma;
    }

    public FormadePagoReserva(Integer idForma, String tipoPago) {
        this.idForma = idForma;
        this.tipoPago = tipoPago;
    }

    public Integer getIdForma() {
        return idForma;
    }

    public void setIdForma(Integer idForma) {
        this.idForma = idForma;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ReservaPaquete getReservaPaquete() {
        return reservaPaquete;
    }

    public void setReservaPaquete(ReservaPaquete reservaPaquete) {
        this.reservaPaquete = reservaPaquete;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idForma != null ? idForma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormadePagoReserva)) {
            return false;
        }
        FormadePagoReserva other = (FormadePagoReserva) object;
        if ((this.idForma == null && other.idForma != null) || (this.idForma != null && !this.idForma.equals(other.idForma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.FormadePagoReserva[ idForma=" + idForma + " ]";
    }
    
}
