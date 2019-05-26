/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dsw.beans;

import br.dsw.dao.PromocaoDAO;
import br.dsw.pojo.Promocao;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author pedro
 */
@ManagedBean
@SessionScoped
public class PromocaoBean implements Serializable{

    private Promocao promocao;
    
    public String lista() {
        return "/promocoes/listar.xhtml";
    }

    public String cadastra() {
        promocao = new Promocao();
        return "/promocoes/alterar.xhtml";
    }

    public String edita(Long id) {
        PromocaoDAO dao = new PromocaoDAO();
        promocao = dao.get(id);
        return "/promocoes/alterar.xhtml";
    }

    public String salva() {
        PromocaoDAO dao = new PromocaoDAO();
        if (promocao.getId() == -1) {
            dao.save(promocao);
        } else {
            dao.update(promocao);
        }
        return "/index.xhtml";
    }

    public String delete(Promocao promocao) {
        PromocaoDAO dao = new PromocaoDAO();
        dao.delete(promocao);
        return "/index.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }
    
    public List<Promocao> getPromocoes() throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        return dao.getAll();
    }

    public Promocao getPromocao() {
        return promocao;
    }
    
    /**
     * Creates a new instance of PromocaoBean
     */
    public PromocaoBean() {
        promocao = new Promocao();
    }
    
}
