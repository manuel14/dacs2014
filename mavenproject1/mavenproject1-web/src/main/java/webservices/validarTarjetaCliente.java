/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;

import javax.jws.WebService;

/**
 *
 * @author Administrator
 */
@WebService(serviceName = "validarTarjeta", portName = "validarTarjetaPort", endpointInterface = "webservices.ValidarTarjeta", targetNamespace = "http://webservices/", wsdlLocation = "WEB-INF/wsdl/localhost_8080/mavenproject1-web/validarTarjeta.wsdl")
public class validarTarjetaCliente {

    public boolean validar(java.lang.String arg0) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
