package billing;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== POWER BILLING SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    register(sc);
                    break;

                case 2:
                    login(sc);
                    break;

                case 3:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    public static void register(Scanner sc) {

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if (AuthService.register(username, password)) {
            System.out.println("Registration Successful!");
        } else {
            System.out.println("Username Already Exists!");
        }
    }

    public static void login(Scanner sc) {

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if (AuthService.login(username, password)) {

            System.out.println("Login Successful!");

            // Updated line
            BillSystem.generateBill(sc);

        } else {
            System.out.println("Invalid Username or Password!");
        }
    }
}
