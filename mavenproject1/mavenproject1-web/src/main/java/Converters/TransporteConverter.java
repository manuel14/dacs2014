/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Converters;

import dacs.dao.TransporteFacade;
import dacs.models.Transporte;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Administrator
 */

@FacesConverter(value = "transporteConverter", forClass = Transporte.class)
public class TransporteConverter implements Converter{
    @EJB
    private TransporteFacade transporteFacade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return transporteFacade.find(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!value.getClass().equals(Transporte.class)) {
            return null;
        }
        Transporte transporte = (Transporte) value;
        return transporte.getIdtransporte().toString();
    }

    
    /**
     * Creates a new instance of TransporteConverter
     */
    public TransporteConverter() {
    }
    
}
