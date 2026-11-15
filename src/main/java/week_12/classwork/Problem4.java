
import java.util.Scanner;

interface PaymentMode {

    double processPayment(double amount);
}

class CashPayment implements PaymentMode {

    public double processPayment(double amount) {

        return amount;
    }
}

class CardPayment implements PaymentMode {

    public double processPayment(double amount) {

        double fee = amount * 0.02;

        return amount + fee;
    }
}

class UPIPayment implements PaymentMode {

    public double processPayment(double amount) {

        return amount;
    }
}

public class Problem4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of payments: ");
        int n = sc.nextInt();

        PaymentMode[] payments = new PaymentMode[n];

        double[] amounts = new double[n];

        String[] modes = new String[n];

        // Accept payment details
        for (int i = 0; i < n; i++) {

            modes[i] = sc.next();

            amounts[i] = sc.nextDouble();

            if (modes[i].equalsIgnoreCase("Cash")) {

                payments[i] = new CashPayment();
            }
            else if (modes[i].equalsIgnoreCase("Card")) {

                payments[i] = new CardPayment();
            }
            else if (modes[i].equalsIgnoreCase("UPI")) {

                payments[i] = new UPIPayment();
            }
        }

        double grandTotal = 0;

        System.out.println("\nPayment Details:");

        for (int i = 0; i < n; i++) {

            double processed =
                    payments[i].processPayment(amounts[i]);

            double fee = processed - amounts[i];

            System.out.printf(
                "%s: amount %.1f, fee %.1f, processed %.1f%n",
                modes[i], amounts[i], fee, processed
            );

            grandTotal += processed;
        }

        System.out.printf("Total Amount Processed: %.1f%n",
                grandTotal);

        sc.close();
    }
}

