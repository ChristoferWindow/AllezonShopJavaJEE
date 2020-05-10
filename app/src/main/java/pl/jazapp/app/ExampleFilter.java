package pl.jazapp.app;

import javax.faces.application.ResourceHandler;
import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.UnsupportedOperationException;

@WebFilter("*")
public class ExampleFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession(false);
        boolean isLoggedIn = (session != null);

        if(isLoggedIn | isSiteAllowed(req) | isResourceReq(req)) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect(req.getContextPath() + "/login.xhtml");
        }
    }

    private boolean isSiteAllowed(HttpServletRequest req) {
        return "/login.xhtml".equals((req.getServletPath())) || "/register.xhtml".equals((req.getServletPath()));
    }

    private boolean isUserAuthenticated(){
        throw new UnsupportedOperationException("ToDo");
    }

    private boolean isResourceReq(HttpServletRequest req) {
        return req.getRequestURI().startsWith(req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + "/");
    }
}
