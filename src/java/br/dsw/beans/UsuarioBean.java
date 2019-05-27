package br.dsw.beans;

import br.dsw.dao.UsuarioDAO;
import br.dsw.pojo.Usuario;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityExistsException;
import javax.persistence.RollbackException;

@SessionScoped
@ManagedBean(name="usuarioBean")
public class UsuarioBean implements Serializable {

    private Usuario usuario;
    private String email;
    private String senha;
    private boolean erro;

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public boolean getErro() {
        boolean erro = this.erro;
        this.erro = false;
        return erro;
    }
    
    public boolean isAdmin() {
        if(this.usuario == null) {
            return false;
        }
        
        return this.usuario.getAdmin();
    }
    
    public String create() {
        UsuarioDAO dao = new UsuarioDAO();
        usuario = new Usuario(this.email, this.senha, true);        
        
        try {
            dao.save(usuario);
        } catch (RollbackException e) {
            this.erro = true;
            this.usuario = null;
            
            return "/usuario/create.xhtml";
        }
        
        return login();
    }

    public String login() {
        UsuarioDAO dao = new UsuarioDAO();
       
        usuario = dao.get(this.email);
        
        if(usuario != null && usuario.getSenha().equals(this.senha)) {
            return "/index.xhtml";
        }

        this.erro = true;
        
        return "/usuario/login.xhtml";
    }
    
    public String logout() {
        this.usuario = null;
        this.email = null;
        this.senha = null;
        
        return "/index.xhtml";
    }
}
