/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dacs.dao;

import dacs.models.Transporte;
import static java.util.Collections.list;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Administrator
 */
@Stateless
public class TransporteFacade extends AbstractFacade<Transporte> {
     @PersistenceContext(unitName = "dacs")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public TransporteFacade(){
        super(Transporte.class);
    }
    
    public List<Transporte> ListarTransportes(){
        //javax.persistence.Query q = getEntityManager().createQuery("select t from Transporte");
        //List<Transporte> transportes =  q.getResultList();
        
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        
        CriteriaQuery<Transporte> q2 = builder.createQuery(Transporte.class);
        Root<Transporte> root = q2.from(Transporte.class);        
        q2.select(root);
        
        TypedQuery<Transporte> tq = em.createQuery(q2);
        
        
        
        return tq.getResultList();
    }
}
