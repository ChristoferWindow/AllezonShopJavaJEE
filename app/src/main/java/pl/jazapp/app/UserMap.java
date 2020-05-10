package pl.jazapp.app;

import pl.jazapp.app.webapp.classes.User;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class UserMap implements Serializable {
    private static HashMap<String, User> usersList;

    static {
        usersList = new HashMap<String, User>();

        String userBirthday="31/12/1998";
        Date date= null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(userBirthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user = new User(
                "test",
                "test",
                "test",
                "test",
                date,
                "test@test.test"
        );
        usersList.put("test", user);
    }

    private static UserMap instance;

    public static UserMap getInstance() throws ParseException {
        if (instance == null) {
            instance = new UserMap();

            String userBirthday="31/12/1998";
            Date date=new SimpleDateFormat("dd/MM/yyyy").parse(userBirthday);
            User user = new User(
                    "test",
                    "test",
                    "test",
                    "test",
                    date,
                    "test@test.test"
            );

            instance.registerUser(user);
        }
        return instance;
    }

    public HashMap<String, User> getUsersList() {
        return usersList;
    }

    public boolean registerUser(User user) {
        for (Map.Entry<String, User> entry : usersList.entrySet()) {
            if (user.getUsername().equals(entry.getKey())) {
                return false;
            }
        }

        usersList.put(user.getUsername(), user);

        return true;
    }

    public User getUser(String login) {
        for (Map.Entry<String, User> entry : usersList.entrySet()) {
            if (login.equals(entry.getKey())) {
                return entry.getValue();
            }
        }

        return null;
    }
}
