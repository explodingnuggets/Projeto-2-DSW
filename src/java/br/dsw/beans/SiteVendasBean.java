/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dsw.beans;

import br.dsw.dao.SiteVendasDAO;
import br.dsw.dao.UsuarioDAO;
import br.dsw.pojo.SiteVendas;
import br.dsw.pojo.Usuario;
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
public class SiteVendasBean {

    private SiteVendas siteVendas;

    public String lista() {
        return "/sites/listar.xhtml";
    }

    public String cadastra() {
        siteVendas = new SiteVendas();
        return "/sites/alterar.xhtml";
    }

    public String cadastraParaUsuario(Usuario u) {
        UsuarioDAO udau = new UsuarioDAO();
        siteVendas = udau.getSiteVendas(u);
        if (siteVendas == null) {
            siteVendas = new SiteVendas();
        }
        siteVendas.setUsuario(u);
        return "/sites/alterar.xhtml";
    }

    public String edita(String id) {
        if (id.isEmpty()) {
            siteVendas = new SiteVendas();
        } else {
            SiteVendasDAO dao = new SiteVendasDAO();
            siteVendas = dao.get(id);
        }
        return "/sites/alterar.xhtml";
    }

    public String salva() throws Exception {
        SiteVendasDAO dao = new SiteVendasDAO();
       try {
            dao.update(siteVendas);
        } catch (Exception e) {
            throw new Exception("Este usuário ja possui site de vendas, ou então o nome já está em uso");
        }
        return lista();
    }

    public String delete(SiteVendas siteVendas) {
        SiteVendasDAO dao = new SiteVendasDAO();
        dao.delete(siteVendas);
        return lista();
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }

    public List<SiteVendas> getSitesVendas() throws SQLException {
        SiteVendasDAO dao = new SiteVendasDAO();
        return dao.getAll();
    }

    public SiteVendas getSiteVendas() {
        return siteVendas;
    }

    public SiteVendasBean() {
        siteVendas = new SiteVendas();
    }
}
