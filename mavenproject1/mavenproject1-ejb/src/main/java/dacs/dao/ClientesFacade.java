/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dacs.dao;

import dacs.model.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrator
 */

@Stateless
public class ClienteFacade extends AbstractFacade<Cliente>{
     @PersistenceContext(unitName = "dacs")
    private EntityManager em;
     
      public ClienteFacade() {
        super(Cliente.class);
    }
    
}
