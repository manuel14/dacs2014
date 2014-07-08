/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dacs.dao;

import dacs.models.Suscripcion;
import dacs.models.Transporte;
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
public class SuscripcionFacade extends AbstractFacade<Suscripcion> {
    @PersistenceContext(unitName = "dacs")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public SuscripcionFacade(){
        super(Suscripcion.class);
    }
    
    public List<Suscripcion> ListarTransportes(){
        
        
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        
        CriteriaQuery<Suscripcion> q2 = builder.createQuery(Suscripcion.class);
        Root<Suscripcion> root = q2.from(Suscripcion.class);        
        q2.select(root);
        
        TypedQuery<Suscripcion> tq = em.createQuery(q2);
        
        
        
        return tq.getResultList();
    }
}
