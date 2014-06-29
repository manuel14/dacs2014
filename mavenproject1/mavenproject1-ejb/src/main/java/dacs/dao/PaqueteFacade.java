/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dacs.dao;

import dacs.models.Paquete;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Administrator
 */
@Stateless
public class PaqueteFacade extends AbstractFacade<Paquete> {
    @PersistenceContext(unitName = "dacs")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public PaqueteFacade(){
        super(Paquete.class);
    }
    
    
    public List<Paquete> ListarPaquetes(){
        //javax.persistence.Query p = getEntityManager().createQuery("select p from Paquete");
        //List<Paquete> paquetes =  p.getResultList();
        
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        
        CriteriaQuery<Paquete> q2 = builder.createQuery(Paquete.class);
        Root<Paquete> root = q2.from(Paquete.class);        
        q2.select(root);
        
        TypedQuery<Paquete> pq = em.createQuery(q2);
        
              
        return pq.getResultList();
    }

  }
