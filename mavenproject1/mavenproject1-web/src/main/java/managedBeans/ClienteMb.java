/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import dacs.dao.ClienteFacade;
import dacs.models.Cliente;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import webservices.validarTarjeta;
/**
 *
 * @author Administrator
 */
@Named(value = "clienteMb")
@ViewScoped
public class ClienteMb {
    
    @EJB
    private ClienteFacade facade;
   
    private Cliente cliente;
   
    @PostConstruct
    public void init(){
        this.cliente = new Cliente();
    }
    
    
    
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public String guardar() {
        facade.create(cliente);
        return "ok";
    }
    public String reservar(String nroTarjeta, Integer cantidad){
        return ("ok");
    }
    
}
