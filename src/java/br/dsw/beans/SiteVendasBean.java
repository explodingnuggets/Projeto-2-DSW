/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dsw.beans;

import br.dsw.dao.SiteVendasDAO;
import br.dsw.pojo.SiteVendas;
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

    public String edita(Long id) {
        SiteVendasDAO dao = new SiteVendasDAO();
        siteVendas = dao.get(id);
        return "/sites/alterar.xhtml";
    }

    public String salva() {
        SiteVendasDAO dao = new SiteVendasDAO();
        if (siteVendas.getId() == -1) {
            dao.save(siteVendas);
        } else {
            dao.update(siteVendas);
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
