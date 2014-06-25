/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import dacs.dao.PaqueteFacade;
import dacs.models.Paquete;
import java.io.Serializable;
import java.util.List;
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
@ManagedBean(name = "paqueteMb")
public class PaqueteMb implements Serializable{

    /**
     * Creates a new instance of PaqueteMb
     */
    
    @EJB
    private PaqueteFacade paquetefacade;
    private Paquete paquete = new Paquete();
    private List<Paquete> paquetes = null;
    public PaqueteMb() {
        super();
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public List<Paquete> getPaquetes() {
        if (this.paquetes == null){
            this.paquetes = paquetefacade.ListarPaquetes();
        }
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }
    
     public void eliminar(){
      try{ 
       paquetefacade.remove(paquete);
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Paquete eliminado exitosamente!"));
      }catch (Exception e){
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar:", e.getMessage()));
      
      }
   }
   

    public void guardar() {
        try {
            if(this.paquete.getIdpaquete()!=null){
                paquetefacade.edit(this.paquete);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Paquete modificado exitosamente!"));
            }
            else{

            paquetefacade.create(this.paquete);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Paquete creado exitosamente!"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Crear:", e.getMessage()));
            System.out.println(e.getMessage());
        }
    }
    
    
    
}
