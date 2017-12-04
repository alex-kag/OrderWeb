package pst.kopendakov.servlets.filters;


import pst.kopendakov.servlets.controller.PageURL;

import javax.servlet.*;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by proton2 on 29.10.2016.
 */
@WebFilter(urlPatterns = "/*" )
public class AuthenticationFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        HttpSession session = req.getSession(false);

        //делаем пропуск нужных нам ресурсов мимо фильтра
        if (uri.contains("/site/js/")||
                uri.contains("/webjars/")){
            chain.doFilter(req,resp);
        }

        if((session == null || session.getAttribute("role") == null) && !(uri.endsWith("jsp") || uri.endsWith("LoginServlet"))){
            RequestDispatcher view = request.getRequestDispatcher(PageURL.LOGIN_ACTION);
            view.forward(request, response);
        }else{
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {}
}
