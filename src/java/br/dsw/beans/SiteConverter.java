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
@FacesConverter(forClass=SiteVendas.class, value = "SiteConverter")
public class SiteConverter implements Converter {

    private SiteVendasDAO siteDAO;
    public SiteConverter() {
         siteDAO = new SiteVendasDAO();
    }
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        long id = -0;
        try {
            String[] splitName = string.split("@",2);
            String id_string = splitName[0];
            id = Long.parseLong(splitName[0]);
            System.out.println(id);
        } catch (Exception e) {

        }
        return siteDAO.get(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return o.toString();
    }

}
