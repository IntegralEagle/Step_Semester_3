import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface for capability
interface SaverModifiable {
    default double getSaverFactor() {
        return 0.75;
    }
}

// Abstract Base Class
abstract class Appliance {
    protected double hours;

    public Appliance(double hours) {
        this.hours = hours;
    }

    public abstract double getPowerWatts();
    public abstract String getApplianceName();

    public double calculateUnits(boolean isSaverRequested) {
        double rawUnits = (getPowerWatts() * hours) / 1000.0;
        if (isSaverRequested && this instanceof SaverModifiable) {
            return rawUnits * ((SaverModifiable) this).getSaverFactor();
        }
        return rawUnits;
    }

    public double calculateCost(double units) {
        return units * 8.0;
    }
}

// Subclasses
class Fridge extends Appliance {
    public Fridge(double hours) {
        super(hours);
    }

    @Override
    public double getPowerWatts() {
        return 150.0;
    }

    @Override
    public String getApplianceName() {
        return "FRIDGE";
    }
}

class AC extends Appliance implements SaverModifiable {
    public AC(double hours) {
        super(hours);
    }

    @Override
    public double getPowerWatts() {
        return 1500.0;
    }

    @Override
    public String getApplianceName() {
        return "AC";
    }
}

class TV extends Appliance {
    public TV(double hours) {
        super(hours);
    }

    @Override
    public double getPowerWatts() {
        return 100.0;
    }

    @Override
    public String getApplianceName() {
        return "TV";
    }
}

class Washer extends Appliance implements SaverModifiable {
    public Washer(double hours) {
        super(hours);
    }

    @Override
    public double getPowerWatts() {
        return 500.0;
    }

    @Override
    public String getApplianceName() {
        return "WASHER";
    }
}

public class EnergyReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = Integer.parseInt(scanner.nextLine().trim());
        double totalCostSum = 0.0;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            String applianceType = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean isSaverRequested = (parts.length > 2 && parts[2].equalsIgnoreCase("SAVER"));

            Appliance appliance = null;
            if (applianceType.equalsIgnoreCase("FRIDGE")) {
                appliance = new Fridge(hours);
            } else if (applianceType.equalsIgnoreCase("AC")) {
                appliance = new AC(hours);
            } else if (applianceType.equalsIgnoreCase("TV")) {
                appliance = new TV(hours);
            } else if (applianceType.equalsIgnoreCase("WASHER")) {
                appliance = new Washer(hours);
            }

            if (appliance != null) {
                if (isSaverRequested && !(appliance instanceof SaverModifiable)) {
                    System.out.printf("%s: saver mode not supported\n", appliance.getApplianceName());
                } else {
                    double units = appliance.calculateUnits(isSaverRequested);
                    double cost = appliance.calculateCost(units);
                    totalCostSum += cost;
                    System.out.printf("%s: Units=%.2f Cost=%.2f\n", appliance.getApplianceName(), units, cost);
                }
            }
        }

        System.out.printf("Total Cost: %.2f\n", totalCostSum);
        scanner.close();
    }
}