/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class LoginMb {

    /**
     * Creates a new instance of loginMb
     */
    
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
            if (request.isUserInRole("rolDeAdministrador")){
                return "irAAdmin";
            }else if (request.isUserInRole("rolDeCliente")){
                return "irACliente";
            }
            else{
                return "irAAdmin";
            }
        }
        catch (Exception e){
            return "irAAdmin";
        }
    }   
    
}
