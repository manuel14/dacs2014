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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "suscripcion" , schema="test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suscripcion.findAll", query = "SELECT s FROM Suscripcion s"),
    @NamedQuery(name = "Suscripcion.findByIdsuscripcion", query = "SELECT s FROM Suscripcion s WHERE s.idsuscripcion = :idsuscripcion"),
    @NamedQuery(name = "Suscripcion.findByCorreo", query = "SELECT s FROM Suscripcion s WHERE s.correo = :correo")})
public class Suscripcion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsuscripcion")
    private Integer idsuscripcion;
    @Size(max = 100)
    @Column(name = "correo")
    private String correo;

    public Suscripcion() {
    }

    public Suscripcion(Integer idsuscripcion) {
        this.idsuscripcion = idsuscripcion;
    }

    public Integer getIdsuscripcion() {
        return idsuscripcion;
    }

    public void setIdsuscripcion(Integer idsuscripcion) {
        this.idsuscripcion = idsuscripcion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsuscripcion != null ? idsuscripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suscripcion)) {
            return false;
        }
        Suscripcion other = (Suscripcion) object;
        if ((this.idsuscripcion == null && other.idsuscripcion != null) || (this.idsuscripcion != null && !this.idsuscripcion.equals(other.idsuscripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dacs.models.Suscripcion[ idsuscripcion=" + idsuscripcion + " ]";
    }
    
}
