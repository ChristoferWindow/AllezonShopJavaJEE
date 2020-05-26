package pl.jazapp.app.webapp.login;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.jazapp.app.UserContext;
import pl.jazapp.app.UserMap;
import pl.jazapp.app.user.User;
import pl.jazapp.app.user.UserEntity;
import pl.jazapp.app.user.UserService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@Named
@RequestScoped
public class LoginController {

    private static final String INVALID_CREDENTIALS_MESSAGE_ID = "Wrong username or password.";

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Inject
    UserMap userMap;

    @Inject
    UserService userService;

    @Inject
    UserContext userContext;
    public String login(LoginRequest loginRequest){
        System.out.println(String.format("Tried to log in with username %s and password %s", loginRequest.getUsername(), loginRequest.getPassword()));

        /* todo nie wyciagac bezposrednio encji do controllera */
        Optional<UserEntity> user = userService.getUserByUsername(loginRequest.getUsername());

        if(user.isPresent() && passwordEncoder.matches(loginRequest.getPassword(), user.get().getPassword())) {

            setUserSession(userContext, user.get().getId() ,user.get().getUsername());
            return "/index.xhtml";
        }
        failLogin();
        return "/login.xhtml?faces-redirect=true";
    }

    private void setUserSession(UserContext userContext, Long userId, String username) {
        userContext.setUserId(userId);
        userContext.setLoggedIn(true);
        userContext.setUsername(username);
    }

    private void failLogin() {
        userContext = new UserContext();
        var flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.putNow("error-message",  INVALID_CREDENTIALS_MESSAGE_ID);
    }
}
