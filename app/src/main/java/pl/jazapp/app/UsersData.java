package pl.jazapp.app;

import java.util.HashMap;

public class UsersData {
    public static HashMap<String, String> usersCredentials;

    static {
        usersCredentials = new HashMap<>();
        usersCredentials.put("test", "test");
    }
}

