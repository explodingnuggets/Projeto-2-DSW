package br.dsw.beans;

import br.dsw.dao.UsuarioDAO;
import br.dsw.pojo.SiteVendas;
import br.dsw.pojo.Teatro;
import br.dsw.pojo.Usuario;
import static com.sun.faces.facelets.util.Path.context;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;

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

    public List<Usuario> getUsuarios() {
        UsuarioDAO dao = new UsuarioDAO();
        return dao.getAll();
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String create() throws Exception {
        UsuarioDAO dao = new UsuarioDAO();
        try {
            dao.save(this.usuario);
        } catch (EntityExistsException e) {
            usuario = new Usuario();
            throw new Exception("Este email já está em uso");
        }
        try {
            login();
        } catch (Exception e) {
            throw e;
        }
        return "/index.xhtml?faces-redirect=true";
    }

    public String login() throws Exception {
        UsuarioDAO dao = new UsuarioDAO();
        String t_senha = usuario.getSenha();
        try {
            usuario = dao.getByEmail(usuario.getEmail());

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user_email", usuario.getEmail());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user_id", usuario.getId());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("is_admin", usuario.getAdmin());
        } catch (NoResultException e) {
           usuario = new Usuario();
            throw new Exception("Usuário não encontrado");
        }
        if(!usuario.getSenha().equals(t_senha)){
            throw new Exception("Senha errada");
        }
        return "/index.xhtml?faces-redirect=true";
    }

    public String visualizar() {
        UsuarioDAO udau = new UsuarioDAO();
        usuario = udau.getByEmail(usuario.getEmail());
        return "/usuario/visualizar.xhtml?faces-redirect=true";
    }

    public String logout() {
        usuario = new Usuario();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("user_email");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("user_id");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("is_admin");
        return "/index.xhtml?faces-redirect=true";

    }

    public Teatro getTeatro() {
        UsuarioDAO udau = new UsuarioDAO();
        return udau.getTeatro(usuario);
    }

    public SiteVendas getSiteVendas() {
        UsuarioDAO udau = new UsuarioDAO();
        return udau.getSiteVendas(usuario);
    }
}
