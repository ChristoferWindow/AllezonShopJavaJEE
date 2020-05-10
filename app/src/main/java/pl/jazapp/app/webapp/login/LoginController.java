package pl.jazapp.app.webapp.login;

import pl.jazapp.app.UserContext;
import pl.jazapp.app.UserMap;
import pl.jazapp.app.UsersData;
import pl.jazapp.app.webapp.classes.User;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginController {

    private static final String INVALID_CREDENTIALS_MESSAGE_ID = "Wrong username or password.";

    @Inject
    UserMap userMap;

    @Inject
    UserContext userContext;
    public String login(LoginRequest loginRequest){
        System.out.println(String.format("Tried to log in with username %s and password %s", loginRequest.getUsername(), loginRequest.getPassword()));
        User user = userMap.getUser(loginRequest.getUsername());

        if(user != null && loginRequest.getPassword().equals(user.getPassword())) {
            setUserSession(userContext, user);
            return "/index.xhtml";
        }
        failLogin();
        return "/login.xhtml?faces-redirect=true";
    }

    private void setUserSession(UserContext userContext, User logIn) {
        userContext.setUsername(logIn.getUsername());
        userContext.setPassword(logIn.getPassword());
        userContext.setFirstname(logIn.getFirstname());
        userContext.setLastname(logIn.getLastname());
        userContext.setBirthdate(logIn.getBirthdate());
        userContext.setEmail(logIn.getEmail());
    }

    private void failLogin() {
        userContext = new UserContext();
        var flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.putNow("error-message",  INVALID_CREDENTIALS_MESSAGE_ID);
    }
}
