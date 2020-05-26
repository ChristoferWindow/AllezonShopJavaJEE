package pl.jazapp.app.user;

import java.util.Date;

public class User {

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private Date birthdate;
    private String email;

    public User(String username, String password, String firstname, String lastname, Date birthdate, String email){
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getEmail() {
        return email;
    }
}
