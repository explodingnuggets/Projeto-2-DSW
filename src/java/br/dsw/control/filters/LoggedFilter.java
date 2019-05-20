package br.dsw.control.filters;

import br.dsw.control.Permissoes;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoggedFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        
        HttpSession session = request.getSession();
        if(!Permissoes.isUserSession(session)) {
            session.removeAttribute("user_id");
            session.removeAttribute("user_email");
            session.removeAttribute("is_admin");
            
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        
        chain.doFilter(req, resp);
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}
