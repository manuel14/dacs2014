/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dacs.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "formadepagoreserva" ,schema="test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormadePagoReserva.findAll", query = "SELECT f FROM FormadePagoReserva f"),
    @NamedQuery(name = "FormadePagoReserva.findByIdforma", query = "SELECT f FROM FormadePagoReserva f WHERE f.idforma = :idforma"),
    @NamedQuery(name = "FormadePagoReserva.findByTipopago", query = "SELECT f FROM FormadePagoReserva f WHERE f.tipopago = :tipopago"),
    @NamedQuery(name = "FormadePagoReserva.findByDescripcion", query = "SELECT f FROM FormadePagoReserva f WHERE f.descripcion = :descripcion")})
public class FormadePagoReserva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idforma")
    private Integer idforma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipopago")
    private String tipopago;
    @Size(max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idreservapaquete", referencedColumnName = "idreservapaquete")
    @ManyToOne(optional = false)
    private ReservaPaquete idreservapaquete;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente idcliente;

    public FormadePagoReserva() {
    }

    public FormadePagoReserva(Integer idforma) {
        this.idforma = idforma;
    }

    public FormadePagoReserva(Integer idforma, String tipopago) {
        this.idforma = idforma;
        this.tipopago = tipopago;
    }

    public Integer getIdforma() {
        return idforma;
    }

    public void setIdforma(Integer idforma) {
        this.idforma = idforma;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ReservaPaquete getIdreservapaquete() {
        return idreservapaquete;
    }

    public void setIdreservapaquete(ReservaPaquete idreservapaquete) {
        this.idreservapaquete = idreservapaquete;
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
        hash += (idforma != null ? idforma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormadePagoReserva)) {
            return false;
        }
        FormadePagoReserva other = (FormadePagoReserva) object;
        if ((this.idforma == null && other.idforma != null) || (this.idforma != null && !this.idforma.equals(other.idforma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dacs.models.FormadePagoReserva[ idforma=" + idforma + " ]";
    }
    
}
