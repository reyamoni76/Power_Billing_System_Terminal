package billing;

public class AuthService {

    public static boolean register(
            String username,
            String password) {

        if (FileManager.userExists(username))
            return false;

        FileManager.saveUser(
                new User(username, password));

        return true;
    }

    public static boolean login(
            String username,
            String password) {

        return FileManager.checkLogin(
                username,
                password);
    }
}
