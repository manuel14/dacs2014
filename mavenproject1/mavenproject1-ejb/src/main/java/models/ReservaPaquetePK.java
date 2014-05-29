/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Administrator
 */
@Embeddable
public class ReservaPaquetePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCliente")
    private int idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPaquete")
    private int idPaquete;

    public ReservaPaquetePK() {
    }

    public ReservaPaquetePK(int idCliente, int idPaquete) {
        this.idCliente = idCliente;
        this.idPaquete = idPaquete;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCliente;
        hash += (int) idPaquete;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaPaquetePK)) {
            return false;
        }
        ReservaPaquetePK other = (ReservaPaquetePK) object;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (this.idPaquete != other.idPaquete) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.ReservaPaquetePK[ idCliente=" + idCliente + ", idPaquete=" + idPaquete + " ]";
    }
    
}
