package pl.jazapp.app.webapp.register;

import pl.jazapp.app.UserMap;
import pl.jazapp.app.user.User;
import pl.jazapp.app.user.UserService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.text.ParseException;

@Named
@RequestScoped
public class RegisterController {

//    @Inject
//    UserMap userMap;
    @Inject
    UserService userService;

    public String register(RegisterRequest registerRequest) throws ParseException {

//        DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
//        String dateAsString = registerRequest.getBirthdate();
//        Date date = sourceFormat.parse(dateAsString);

        User user = new User(
                registerRequest.getUsername(),
                registerRequest.getPassword(),
                registerRequest.getFirstname(),
                registerRequest.getLastname(),
                registerRequest.getBirthdate(),
                registerRequest.getEmail()
        );

        if (userService.create(user)) {
            return "/login.xhtml?faces-redirect=true";
        }
        var flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.put("error-message", "User already exist!");

        return "/register.xhtml?faces-redirect=true";

    }
}
