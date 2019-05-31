/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dsw.beans;

import br.dsw.dao.SiteVendasDAO;
import br.dsw.pojo.SiteVendas;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author pedro
 */
@FacesConverter(forClass = SiteVendas.class, value = "SiteConverter")
public class SiteConverter implements Converter {

    private SiteVendasDAO siteDAO;

    public SiteConverter() {
        siteDAO = new SiteVendasDAO();
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.isEmpty() || string.equals("Sem site de vendas")) {
            return null;
        }
        return siteDAO.get(string);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null || !(o instanceof SiteVendas)) {
            return "Sem site de vendas";
        }
        return o.toString();
    }

}
