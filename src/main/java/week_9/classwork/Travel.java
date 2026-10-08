import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract Base Class
abstract class TravelBooking {
    protected static final double BOOKING_FEE = 50.0; // Centralized fee
    protected double distanceKm;

    public TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract double calculateBaseFare();
    public abstract String getMode();

    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

// Subclasses
class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 2.0;
    }

    @Override
    public String getMode() {
        return "BUS";
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 1.5;
    }

    @Override
    public String getMode() {
        return "TRAIN";
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 2500.0 + (distanceKm * 4.0);
    }

    @Override
    public String getMode() {
        return "FLIGHT";
    }
}

public class Travel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<TravelBooking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distance = scanner.nextDouble();

            if (mode.equalsIgnoreCase("BUS")) {
                bookings.add(new BusBooking(distance));
            } else if (mode.equalsIgnoreCase("TRAIN")) {
                bookings.add(new TrainBooking(distance));
            } else if (mode.equalsIgnoreCase("FLIGHT")) {
                bookings.add(new FlightBooking(distance));
            }
        }

        for (TravelBooking booking : bookings) {
            System.out.printf("%s: %.2f\n", booking.getMode(), booking.calculateTotalFare());
        }

        scanner.close();
    }
}