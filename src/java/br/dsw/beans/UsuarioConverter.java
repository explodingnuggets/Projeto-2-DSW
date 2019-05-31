/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dsw.beans;

import br.dsw.dao.SiteVendasDAO;
import br.dsw.dao.UsuarioDAO;
import br.dsw.pojo.SiteVendas;
import br.dsw.pojo.Teatro;
import br.dsw.pojo.Usuario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author pedro
 */
@FacesConverter(forClass = Usuario.class, value = "UsuarioConverter")
public class UsuarioConverter implements Converter {

    private UsuarioDAO dao;

    public UsuarioConverter() {
        dao = new UsuarioDAO();
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.isEmpty() || string.equals("Sem Usuario")) {
            return null;
        }
        return dao.getByEmail(string);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null || !(o instanceof Usuario)) {
            return "Sem Usuario";
        }
        return o.toString();
    }

}
