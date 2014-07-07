/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Converters;

import dacs.dao.EventoFacade;
import dacs.models.Evento;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Administrator
 */

@FacesConverter(value = "eventoConverter", forClass = Evento.class)
public class EventoConverter implements Converter{
    @EJB
    private EventoFacade EventoFacade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return EventoFacade.find(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!value.getClass().equals(Evento.class)) {
            return null;
        }
        Evento Evento = (Evento) value;
        return Evento.getIdevento().toString();
    }

    
    /**
     * Creates a new instance of EventoConverter
     */
    public EventoConverter() {
    }
    
}
