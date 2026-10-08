import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract Base Class
abstract class ElectricityConnection {
    protected double units;

    public ElectricityConnection(double units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getType();
}

// Subclasses
class HomeConnection extends ElectricityConnection {
    public HomeConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }

    @Override
    public String getType() {
        return "HOME";
    }
}

class ShopConnection extends ElectricityConnection {
    public ShopConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }

    @Override
    public String getType() {
        return "SHOP";
    }
}

class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        double bill = units * 6.0;
        return Math.max(bill, 1000.0);
    }

    @Override
    public String getType() {
        return "FACTORY";
    }
}

public class Electric {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<ElectricityConnection> connections = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double units = scanner.nextDouble();

            if (type.equalsIgnoreCase("HOME")) {
                connections.add(new HomeConnection(units));
            } else if (type.equalsIgnoreCase("SHOP")) {
                connections.add(new ShopConnection(units));
            } else if (type.equalsIgnoreCase("FACTORY")) {
                connections.add(new FactoryConnection(units));
            }
        }

        double totalAmount = 0.0;
        for (ElectricityConnection conn : connections) {
            double bill = conn.calculateBill();
            totalAmount += bill;
            System.out.printf("%s: %.2f\n", conn.getType(), bill);
        }

        System.out.printf("Total: %.2f\n", totalAmount);
        scanner.close();
    }
}