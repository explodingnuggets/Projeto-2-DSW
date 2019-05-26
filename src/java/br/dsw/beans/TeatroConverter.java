/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dsw.beans;

import br.dsw.dao.TeatroDAO;
import br.dsw.pojo.Teatro;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author pedro
 */
@FacesConverter(forClass=Teatro.class, value = "TeatroConverter")
public class TeatroConverter implements Converter {

    private TeatroDAO teatroDao;
    public TeatroConverter() {
         teatroDao = new TeatroDAO();
    }
    

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        long id = 0;
        try {
            String[] splitName = string.split("@", 2);
            id = Long.parseLong(splitName[0]);
        } catch (Exception e) {
        }
        return teatroDao.get(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return o.toString();
    }

}
