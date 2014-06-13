/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import dacs.dao.TransporteFacade;
import dacs.models.Transporte;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
    @ManagedProperty("#{transportes}")
    private List<Transporte> transportes = null;

    public List<Transporte> getTransportes() {
        if(this.transportes == null) {
            this.transportes = transportefacade.ListarTransportes();
        }
        return transportes;
    }

    public void setTransportes(List<Transporte> transportes) {
        this.transportes = transportes;
    }
   
    
    

    

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
