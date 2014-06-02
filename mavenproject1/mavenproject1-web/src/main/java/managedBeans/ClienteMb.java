/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import dacs.models.Cliente;
/**
 *
 * @author Administrator
 */
@Named(value = "clienteMb")
@SessionScoped

public class ClienteMb {
    
    
    /**
     * Creates a new instance of ClienteMb
     */
    public ClienteMb() {
    }
    
}
