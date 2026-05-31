package billing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BillSystem {

    public static void generateBill(Scanner sc) {

        try {

            EBill bill = new EBill();

            System.out.print("Consumer Number: ");
            int no = sc.nextInt();
            sc.nextLine();

            System.out.print("Consumer Name: ");
            String name = sc.nextLine();

            System.out.print("Previous Reading: ");
            int prev = sc.nextInt();

            System.out.print("Current Reading: ");
            int curr = sc.nextInt();
            sc.nextLine();

            if (curr < prev) {
                System.out.println(
                        "Error: Current reading cannot be less than previous reading!");
                return;
            }

            System.out.print(
                    "Connection Type (Domestic/Commercial): ");
            String type = sc.nextLine();

            bill.setData(no, name, prev, curr, type);
            bill.calculate();

            // ===== BILL DISPLAY =====
            System.out.println("\n========== BILL ==========");

            System.out.println(
                    "Energy Charge : " + bill.getEnergy());

            System.out.println(
                    "Meter Rent    : " + bill.getMeter());

            System.out.println(
                    "Demand Charge : " + bill.getDemand());

            System.out.println(
                    "VAT (5%)      : " + bill.getVat());

            System.out.println(
                    "----------------------------");

            System.out.println(
                    "Total Bill    : "
                            + bill.getTotal()
                            + " BDT");

            // ===== BILL MENU =====
            while (true) {

                System.out.println(
                        "\n===== BILL MENU =====");

                System.out.println(
                        "1. Pay Bill");

                System.out.println(
                        "2. Download PDF");

                System.out.println(
                        "3. Exit");

                System.out.print(
                        "Choose Option: ");

                int option = sc.nextInt();
                sc.nextLine();

                switch (option) {

                    case 1:
                        PaymentSystem.payBill(
                                bill, sc);
                        break;

                    case 2:
                        PDFGenerator.generate(
                                bill);

                        System.out.println(
                                "PDF Generated Successfully!");
                        break;

                    case 3:
                        System.out.println(
                                "Thank You!");
                        System.exit(0);

                    default:
                        System.out.println(
                                "Invalid Option! Try again.");
                }
            }

        } catch (InputMismatchException e) {

            System.out.println(
                    "Invalid input type! Please enter correct values.");
            sc.nextLine();

        } catch (Exception e) {

            System.out.println(
                    "Error: " + e.getMessage());
        }
    }
}
