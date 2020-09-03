package pl.jazapp.app;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class UserContext implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long userId;
    private String username;
    private boolean loggedIn;

    public UserContext(){

    }

    public UserContext(Long userId){

        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) { this.userId = userId; }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }
}
