package pl.jazapp.app.webapp;

import pl.jazapp.app.UserContext;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LogoutController {

    @Inject
    UserContext userContext;

    public String logout(){

        userContext.setUserId(null);
        userContext.setUsername(null);
        userContext.setLoggedIn(false);

        return "login.xhtml?faces-redirect=true";
    }
}
