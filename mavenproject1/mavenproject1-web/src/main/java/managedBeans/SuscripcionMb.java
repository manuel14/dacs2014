/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import dacs.dao.SuscripcionFacade;
import dacs.models.Suscripcion;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Administrator
 */
@ViewScoped
@ManagedBean(name = "suscripcionMb")
public class SuscripcionMb implements Serializable{
    
    private Suscripcion suscripcion = new Suscripcion();
    
    public SuscripcionMb(){
            super();
}
    public Suscripcion getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(Suscripcion suscripcion) {
        this.suscripcion = suscripcion;
    }
    
    
    @EJB
    private SuscripcionFacade suscripcionfacade;

    /**
     * Creates a new instance of SuscripcionMb
     */
   
     public void guardar() {
        try {
            if(this.suscripcion.getIdsuscripcion()!=null){
                suscripcionfacade.edit(this.suscripcion);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Suscripcion modificado exitosamente!"));
            }
            else{
            System.out.println("guardando");
            suscripcionfacade.create(this.suscripcion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Suscripcion guardada exitosamente!"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Crear:", e.getMessage()));
            System.out.println(e.getMessage());
        }
    }
     
     public void enviar(String usuario, String password,  String destinatario
                         ){
     
     
     }
     
     
    
}
