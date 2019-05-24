package br.dsw.beans;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean
public class LoginBean implements Serializable {

    public LoginBean() {
      System.out.println("LoginBean started!");   
   }
    
    public String login() {
        return "/faces/index?faces-redirect=true";
    }
}
