/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Converters;

import dacs.dao.HotelFacade;
import dacs.models.Hotel;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Administrator
 */

@FacesConverter(value = "hotelConverter", forClass = Hotel.class)
public class HotelConverter implements Converter{
    @EJB
    private HotelFacade hotelFacade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return hotelFacade.find(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!value.getClass().equals(Hotel.class)) {
            return null;
        }
        Hotel hotel = (Hotel) value;
        return hotel.getIdhotel().toString();
    }

    
    /**
     * Creates a new instance of TransporteConverter
     */
    public HotelConverter() {
    }
    
}
