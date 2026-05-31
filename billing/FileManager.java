package billing;

import java.io.*;

public class FileManager {

    public static void saveUser(User user) {

        try {

            FileWriter fw =
                    new FileWriter("users.txt", true);

            fw.write(
                    user.getUsername() + "," +
                            user.getPassword().hashCode() +
                            "\n"
            );

            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean userExists(String username) {

        try {

            File file = new File("users.txt");

            if (!file.exists())
                return false;

            BufferedReader br =
                    new BufferedReader(
                            new FileReader(file));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data[0].equals(username)) {
                    br.close();
                    return true;
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean checkLogin(
            String username,
            String password) {

        try {

            File file = new File("users.txt");

            if (!file.exists())
                return false;

            BufferedReader br =
                    new BufferedReader(
                            new FileReader(file));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data[0].equals(username)
                        &&
                        data[1].equals(
                                String.valueOf(
                                        password.hashCode()))) {

                    br.close();
                    return true;
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
