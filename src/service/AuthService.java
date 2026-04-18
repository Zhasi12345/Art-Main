package service;
import model.User;

public class AuthService {

    public static User login(String u, String p) {

        if (u.equals("admin") && p.equals("admin123"))
            return new User("ADMIN");

        if (u.equals("user") && p.equals("user123"))
            return new User("USER");

        return null;
    }
}