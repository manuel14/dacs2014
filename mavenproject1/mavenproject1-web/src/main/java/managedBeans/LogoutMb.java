/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrator
 */
@ViewScoped
@ManagedBean(name = "logoutMb")
public class LogoutMb implements Serializable{
      private static Logger log = Logger.getLogger(LogoutMb.class.getName());

    public LogoutMb() {
    }

    
  
      
     public String logout() {
    String result="index?faces-redirect=true";
    
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
    
    try {
      request.logout();
    } catch (ServletException e) {
      log.log(Level.SEVERE, "Failed to logout user!", e);
      result = "test?faces-redirect=true";
    }
    
    return result;
  }
}

    /**
     * Creates a new instance of LogoutMb
     */
    
    

