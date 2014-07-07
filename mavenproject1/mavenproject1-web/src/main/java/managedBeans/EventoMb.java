/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import dacs.dao.EventoFacade;
import dacs.models.Evento;
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
@ManagedBean(name = "eventoMb")
public class EventoMb implements Serializable{

    /**
     * Creates a new instance of EventoMb
     */
    
    @EJB
    private EventoFacade eventofacade;
    private Evento evento = new Evento();

    public Evento getEvento() {
        return evento;
    }
    
    
    
    public EventoMb(){
        super();
    }
    

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    private List<Evento> eventos = null;
    
    public List<Evento> getEventos() {
        if (this.eventos==null) {
            this.eventos = eventofacade.ListarEventos();
            
        }
 
        return eventos;
    }
    public void SetEventos(List<Evento> eventos){
        this.eventos = eventos;
    }
    
      public void eliminar(){
      try{ 
       eventofacade.remove(evento);
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Evento eliminado exitosamente!"));
      }catch (Exception e){
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar:", e.getMessage()));
      
      }
   }
   

    public void guardar() {
        try {
            if(this.evento.getIdevento()!=null){
                eventofacade.edit(this.evento);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Evento modificado exitosamente!"));
            }
            else{

            eventofacade.create(this.evento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Evento creado exitosamente!"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Crear:", e.getMessage()));
            System.out.println(e.getMessage());
        }
    }
}
