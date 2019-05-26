package br.dsw.beans;

import br.dsw.dao.UsuarioDAO;
import br.dsw.pojo.Usuario;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

@SessionScoped
@ManagedBean
public class UsuarioBean implements Serializable {

    private Usuario usuario;

    public UsuarioBean() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String create() throws EntityExistsException {
        UsuarioDAO dao = new UsuarioDAO();
        try {
            dao.save(this.usuario);
        } catch (EntityExistsException e) {
            throw e;
        }

        return login();
    }

    public String login() {
        UsuarioDAO dao = new UsuarioDAO();
       
            usuario = dao.get(usuario.getEmail(), usuario.getSenha());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user_email", usuario.getEmail());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user_id", usuario.getId());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("is_admin", usuario.getAdmin());

        
 
       return "/index.xhtml";
    }

    public String logout() {
        usuario = new Usuario();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("user_email");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("user_id");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("is_admin");
        return "/index.xhtml";

    }
}
