/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dacs.dao;

import dacs.models.Evento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrator
 */
@Stateless 
public class EventoFacade extends AbstractFacade<Evento> {
      @PersistenceContext(unitName = "dacs")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public EventoFacade(){
        super(Evento.class);
    }
}
