package pl.jazapp.app.webapp.register;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Date;

@RequestScoped
@Named
public class RegisterRequest {
    private String username;
    private String password;
    private String repeatPassword;
    private String firstname;
    private String lastname;
    private Date birthdate;
    private String email;

    public String getUsername() {
        return username;
    }
    public String getPassword() { return password; }
    public String getRepeatPassword() { return repeatPassword; }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public Date getBirthdate() { return birthdate; }
    public String getEmail() { return email; }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRepeatPassword(String repeatpassword) {
        this.repeatPassword = repeatpassword;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setBirthdate(Date birthdate) { this.birthdate = birthdate; }
    public void setEmail(String email){ this.email = email; }
}
