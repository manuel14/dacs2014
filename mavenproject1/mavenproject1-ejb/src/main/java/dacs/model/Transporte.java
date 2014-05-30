/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dacs.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "Transporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transporte.findAll", query = "SELECT t FROM Transporte t"),
    @NamedQuery(name = "Transporte.findByIdTransporte", query = "SELECT t FROM Transporte t WHERE t.idTransporte = :idTransporte"),
    @NamedQuery(name = "Transporte.findByTipoTransporte", query = "SELECT t FROM Transporte t WHERE t.tipoTransporte = :tipoTransporte")})
public class Transporte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTransporte")
    private Integer idTransporte;
    @Size(max = 20)
    @Column(name = "tipoTransporte")
    private String tipoTransporte;
    @JoinColumn(name = "idPaquete", referencedColumnName = "idPaquete")
    @ManyToOne(optional = false)
    private Paquete idPaquete;

    public Transporte() {
    }

    public Transporte(Integer idTransporte) {
        this.idTransporte = idTransporte;
    }

    public Integer getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(Integer idTransporte) {
        this.idTransporte = idTransporte;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public Paquete getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(Paquete idPaquete) {
        this.idPaquete = idPaquete;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransporte != null ? idTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transporte)) {
            return false;
        }
        Transporte other = (Transporte) object;
        if ((this.idTransporte == null && other.idTransporte != null) || (this.idTransporte != null && !this.idTransporte.equals(other.idTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Transporte[ idTransporte=" + idTransporte + " ]";
    }
    
}
