package br.dsw.beans;

import br.dsw.dao.UsuarioDAO;
import br.dsw.pojo.Usuario;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;
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

    public String login() throws NoResultException {
        UsuarioDAO dao = new UsuarioDAO();
        try {
            usuario = dao.get(usuario.getEmail(), usuario.getSenha());
        } catch (NoResultException e) {
            throw e;
        }

        return "/index.xhtml";
    }

    public String logout() {
        usuario = new Usuario();
        return "/index.xhtml";

    }
}
