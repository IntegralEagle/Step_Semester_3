import java.util.Scanner;

abstract class PaymentMethod {
    protected double amount;

    public PaymentMethod(double amount) {
        this.amount = amount;
    }

    public abstract double calculateAdjustedAmount();
}

class CardPayment extends PaymentMethod {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.02; // 2% processing fee
    }
}

class WalletPayment extends PaymentMethod {
    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.01; // 1% processing fee
    }
}

class BankTransferPayment extends PaymentMethod {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.00; // No fee
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            PaymentMethod payment;

            switch (type) {
                case "CARD":
                    payment = new CardPayment(amount);
                    break;
                case "WALLET":
                    payment = new WalletPayment(amount);
                    break;
                case "BANKTRANSFER":
                    payment = new BankTransferPayment(amount);
                    break;
                default:
                    continue;
            }

            double adjusted = payment.calculateAdjustedAmount();
            total += adjusted;
            System.out.printf("%s: %.2f%n", type, adjusted);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}