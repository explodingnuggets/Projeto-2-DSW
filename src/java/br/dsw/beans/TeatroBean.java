/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dsw.beans;

import br.dsw.dao.TeatroDAO;
import br.dsw.pojo.Teatro;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author pedro
 */
@ManagedBean
@RequestScoped
public class TeatroBean {

    private Teatro teatro;

    public String lista() {
        return "/teatros/listar.xhtml";
    }

    public String cadastra() {
        teatro = new Teatro();
        return "/teatros/alterar.xhtml";
    }

    public String edita(Long id) {
        TeatroDAO dao = new TeatroDAO();
        teatro = dao.get(id);
        return "/teatros/alterar.xhtml";
    }

    public String salva() {
        TeatroDAO dao = new TeatroDAO();
        if (teatro.getId() == -1) {
            dao.save(teatro);
        } else {
            dao.update(teatro);
        }
        return lista();
    }

    public String delete(Teatro teatro) {
        TeatroDAO dao = new TeatroDAO();
        dao.delete(teatro);
        return "/index.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }

    public List<Teatro> getTeatros() throws SQLException {
        TeatroDAO dao = new TeatroDAO();
        return dao.getAll();
    }

    public Teatro getTeatro() {
        return teatro;
    }

    public TeatroBean() {
        teatro = new Teatro();
    }
}
