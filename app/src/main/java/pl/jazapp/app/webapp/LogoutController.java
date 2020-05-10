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

        userContext.setUsername(null);
        userContext.setPassword(null);
        userContext.setFirstname(null);
        userContext.setLastname(null);
        userContext.setBirthdate(null);
        userContext.setEmail(null);
        userContext.setLoggedIn(false);

        return "login.xhtml?faces-redirect=true";
    }
}
