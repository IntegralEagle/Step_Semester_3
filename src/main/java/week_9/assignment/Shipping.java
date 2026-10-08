import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface for capability
interface Insurable {
    double calculateInsurance();
}

// Abstract Base Class
abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;

    public Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateShippingCharge();
    public abstract String getType();

    public double getInsuranceCharge() {
        if (this instanceof Insurable) {
            return ((Insurable) this).calculateInsurance();
        }
        return 0.0;
    }

    public double calculateTotal() {
        return calculateShippingCharge() + getInsuranceCharge();
    }
}

// Subclasses
class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return 40.0 + (10.0 * weightKg);
    }

    @Override
    public String getType() {
        return "STANDARD";
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return 80.0 + (15.0 * weightKg);
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }

    @Override
    public String getType() {
        return "EXPRESS";
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        StandardParcel tempStandard = new StandardParcel(weightKg, declaredValue);
        return tempStandard.calculateShippingCharge() + 50.0;
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }

    @Override
    public String getType() {
        return "FRAGILE";
    }
}

public class Shipping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Parcel> parcels = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double value = scanner.nextDouble();

            if (type.equalsIgnoreCase("STANDARD")) {
                parcels.add(new StandardParcel(weight, value));
            } else if (type.equalsIgnoreCase("EXPRESS")) {
                parcels.add(new ExpressParcel(weight, value));
            } else if (type.equalsIgnoreCase("FRAGILE")) {
                parcels.add(new FragileParcel(weight, value));
            }
        }

        double grandTotal = 0.0;
        for (Parcel parcel : parcels) {
            double charge = parcel.calculateShippingCharge();
            double insurance = parcel.getInsuranceCharge();
            double total = parcel.calculateTotal();
            grandTotal += total;

            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", 
                parcel.getType(), charge, insurance, total);
        }

        System.out.printf("Grand Total: %.2f\n", grandTotal);
        scanner.close();
    }
}