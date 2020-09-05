package pl.jazapp.app;

import pl.jazapp.app.user.UserEntity;
import pl.jazapp.app.user.UserService;

import javax.faces.application.ResourceHandler;
import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.UnsupportedOperationException;
import java.util.Optional;

@WebFilter("*")
public class ExampleFilter extends HttpFilter {

    @Inject
    UserContext userContext;

    @Inject
    UserService userService;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession(false);
        boolean isLoggedIn = (session != null);

        if(isLoggedIn | isSiteAllowed(req) | isResourceReq(req)) {
            if(isAdmin()) {
                chain.doFilter(req, res);
            } else if (!((req.getRequestURI().equals("/app/departments/edit.xhtml"))
                    | req.getRequestURI().equals("/app/categories/edit.xhtml"))) {
                chain.doFilter(req, res);
            } else {
                res.sendRedirect(req.getContextPath() + "/");
            }
        } else {
            res.sendRedirect(req.getContextPath() + "/login.xhtml");
        }
    }

    private boolean isAdmin() {
        var userId = userContext.getUserId();
        Optional<UserEntity> userEntity = userService.getById(userId);

        if (userEntity.isPresent()) {
            String role = userEntity.get().getRole();
            String role2 = role.replaceAll("\\s+", "");
            if(role2.equals("ADMIN")) {
                return true;
            }
            return false;
        }
        return false;
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
