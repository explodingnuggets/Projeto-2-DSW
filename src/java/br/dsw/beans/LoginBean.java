package br.dsw.beans;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private Boolean logged = false;

    public Boolean getLogged() {
        return logged;
    }

    public String login() {
        logged = true;
        return "/faces/index?faces-redirect=true";
    }
}
