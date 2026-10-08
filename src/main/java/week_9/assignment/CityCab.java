import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface for capability
interface NightServiceable {
    default double applyNightSurcharge(double baseFare) {
        return baseFare * 1.20;
    }
}

// Abstract Base Class
abstract class Cab {
    protected double km;

    public Cab(double km) {
        this.km = km;
    }

    public abstract double getRatePerKm();
    public abstract String getCabType();

    public double calculateBaseFare() {
        double rawFare = km * getRatePerKm();
        return Math.max(rawFare, 100.0);
    }
}

// Subclasses
class MiniCab extends Cab {
    public MiniCab(double km) {
        super(km);
    }

    @Override
    public double getRatePerKm() {
        return 10.0;
    }

    @Override
    public String getCabType() {
        return "MINI";
    }
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab(double km) {
        super(km);
    }

    @Override
    public double getRatePerKm() {
        return 14.0;
    }

    @Override
    public String getCabType() {
        return "SEDAN";
    }
}

class SUVCab extends Cab implements NightServiceable {
    public SUVCab(double km) {
        super(km);
    }

    @Override
    public double getRatePerKm() {
        return 18.0;
    }

    @Override
    public String getCabType() {
        return "SUV";
    }
}

public class CityCab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        double totalFareSum = 0.0;

        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();

            Cab cab = null;
            if (cabType.equalsIgnoreCase("MINI")) {
                cab = new MiniCab(km);
            } else if (cabType.equalsIgnoreCase("SEDAN")) {
                cab = new SedanCab(km);
            } else if (cabType.equalsIgnoreCase("SUV")) {
                cab = new SUVCab(km);
            }

            if (cab != null) {
                if (time.equalsIgnoreCase("NIGHT")) {
                    if (cab instanceof NightServiceable) {
                        double fare = ((NightServiceable) cab).applyNightSurcharge(cab.calculateBaseFare());
                        totalFareSum += fare;
                        System.out.printf("%s: %.2f\n", cab.getCabType(), fare);
                    } else {
                        System.out.printf("%s: night service not available\n", cab.getCabType());
                    }
                } else {
                    double fare = cab.calculateBaseFare();
                    totalFareSum += fare;
                    System.out.printf("%s: %.2f\n", cab.getCabType(), fare);
                }
            }
        }

        System.out.printf("Total: %.2f\n", totalFareSum);
        scanner.close();
    }
}