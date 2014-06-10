/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import dacs.dao.TransporteFacade;
import dacs.models.Transporte;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Administrator
 */
@ViewScoped
@ManagedBean(name = "transporteMb")
public class TransporteMb implements Serializable {

    @EJB
    private TransporteFacade transportefacade;

    

    private Transporte transporte;

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public TransporteMb() {
        super();
        this.transporte = new Transporte();

    }

    public void guardar() {
        try {

            transportefacade.create(this.transporte);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Transporte creado exitosamente!"));
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Crear:", e.getMessage()));
            System.out.println(e.getMessage());
        }
    }

}
