/*
 - * To change this license header, choose License Headers in Project Properties.
 - * To change this template file, choose Tools | Templates
 - * and open the template in the editor.
 - */
 
 package managedBeans;
 
 import java.io.Serializable;
 import java.util.logging.Logger;
 import javax.enterprise.context.SessionScoped;
 import javax.faces.context.ExternalContext;
 import javax.faces.context.FacesContext;
 import javax.inject.Named;
 import javax.servlet.http.HttpServletRequest;
 
 /**
  *
  * @author Admin
  */
 @Named
 @SessionScoped
 public class LoginMb implements Serializable {
 
     /**
      * Creates a new instance of loginMb
     */
    
     private Logger logger = Logger.getLogger(LoginMb.class.getName());
    
    private String user;
     private String pass;
    
     public LoginMb() {
     }
 
     public String getUser() {
        return user;
    }
 
    public void setUser(String user) {
         this.user = user;
     }
 
    public String getPass() {
        return pass;
    }
 
    public void setPass(String pass) {
        this.pass = pass;
     }
    
     public String login(){
         ExternalContext external = FacesContext.getCurrentInstance().getExternalContext();
         HttpServletRequest request = (HttpServletRequest)external.getRequest();
        try{
            request.login(user, pass);
            
             logger.info("Verificando si es Admin");
            
            if (request.isUserInRole("ADMIN"))
                return "/admin/home";
            
             logger.info("Verificando si es Cliente");
 
             if (request.isUserInRole("USER"))
                return "irACliente";
            
            logger.info("FRACASOOO");
            return "fracaso";
         }
        catch (Exception e){
            return "fracaso";
        }
     }   
    
 }