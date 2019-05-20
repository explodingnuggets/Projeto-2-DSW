package br.dsw.control;

import br.dsw.dao.UsuarioDAO;
import javax.servlet.http.HttpSession;

public class Permissoes {
    public static boolean isAdminSession(HttpSession session) {
        Object userId = session.getAttribute("user_id");
        if(userId != null) {
            UsuarioDAO dao = new UsuarioDAO();
            return dao.get((long) userId).getAdmin();
        }
        
        return false;
    }
}
