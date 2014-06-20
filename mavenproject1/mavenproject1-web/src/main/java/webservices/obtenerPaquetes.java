/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;

import dacs.dao.PaqueteFacade;
import dacs.models.Paquete;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Verónica
 */
@WebService(serviceName = "obtenerPaquetes")
public class obtenerPaquetes {

    /**
     * Web service operation
     * @return 
     */
    
    @EJB
    private PaqueteFacade paquetefacade;
    private List<Paquete> paquetes=null;
    @WebMethod(operationName = "ListarTodo")
    public List<Paquete> ListarTodo() {
                       
            if(this.paquetes == null) {
            this.paquetes = paquetefacade.ListarPaquetes();
        }
        return paquetes;
    }

  }
