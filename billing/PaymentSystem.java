package billing;

import java.util.Scanner;

public class PaymentSystem {

    public static void payBill(EBill bill,
                               Scanner sc) {

        while (true) {

            System.out.println("\n===== BILL PAYMENT =====");
            System.out.println("Total Bill: "
                    + bill.getTotal()
                    + " BDT");

            System.out.println("1. bKash");
            System.out.println("2. Nagad");
            System.out.println("3. Card");
            System.out.println("0. Back");

            System.out.print("Choose Method: ");

            int choice = sc.nextInt();
            sc.nextLine();

            String method = "";

            switch (choice) {

                case 1:
                    method = "bKash";
                    break;

                case 2:
                    method = "Nagad";
                    break;

                case 3:
                    method = "Card";
                    break;

                case 0:
                    return;

                default:
                    System.out.println(
                            "Invalid Choice!");
                    continue;
            }

            System.out.println(
                    "\n===== "
                            + method
                            + " PAYMENT =====");

            System.out.println(
                    "Enter 0 to go back");

            System.out.print(
                    "Account Number: ");

            String number =
                    sc.nextLine();

            if (number.equals("0")) {
                continue;
            }

            System.out.print(
                    "Transaction ID: ");

            String trx =
                    sc.nextLine();

            if (trx.equals("0")) {
                continue;
            }

            System.out.println(
                    "\n1. Confirm Payment");

            System.out.println(
                    "2. Back");

            System.out.print(
                    "Choose: ");

            int confirm =
                    sc.nextInt();

            sc.nextLine();

            if (confirm == 2) {
                continue;
            }

            Payment payment =
                    new Payment(
                            bill.getTotal(),
                            method,
                            trx
                    );

            System.out.println(
                    "\n===== PAYMENT RECEIPT =====");

            System.out.println(
                    "Method : "
                            + payment.getMethod());

            System.out.println(
                    "Amount : "
                            + payment.getAmount()
                            + " BDT");

            System.out.println(
                    "Transaction ID : "
                            + payment.getTransactionId());

            System.out.println(
                    "Status : PAID");

            break;
        }
    }
}
