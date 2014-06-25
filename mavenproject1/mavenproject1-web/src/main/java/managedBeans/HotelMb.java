/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import dacs.dao.HotelFacade;
import dacs.models.Hotel;
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
@ManagedBean(name = "hotelMb")
public class HotelMb implements Serializable{
    @EJB
    private HotelFacade hotelfacade;
    private Hotel hotel = new Hotel();

    public Hotel getHotel() {
        return hotel;
    }
    
    
    
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
    private List<Hotel> hoteles = null;
    
    public List<Hotel> getHoteles() {
        if (this.hoteles==null) {
            this.hoteles = hotelfacade.ListarHoteles();
            
        }
 
        return hoteles;
    }
    public void SetHoteles(List<Hotel> hoteles){
        this.hoteles = hoteles;
    }
    
      public void eliminar(){
      try{ 
       hotelfacade.remove(hotel);
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hotel eliminado exitosamente!"));
      }catch (Exception e){
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar:", e.getMessage()));
      
      }
   }
   

    public void guardar() {
        try {
            if(this.hotel.getIdhotel()!=null){
                hotelfacade.edit(this.hotel);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hotel modificado exitosamente!"));
            }
            else{

            hotelfacade.create(this.hotel);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hotel creado exitosamente!"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Crear:", e.getMessage()));
            System.out.println(e.getMessage());
        }
    }
    
    
    /**
     * Creates a new instance of HotelMb
     */
   
    
}
