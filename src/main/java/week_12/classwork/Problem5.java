
import java.util.Scanner;

public class Problem5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] rainfall = new double[7];

        double total = 0;

        double max = -1;

        int wettestDay = 0;

        int dryDays = 0;

        // Input rainfall
        System.out.println("Enter rainfall for 7 days:");

        for (int i = 0; i < 7; i++) {

            rainfall[i] = sc.nextDouble();
        }

        // Calculate total, wettest day and dry days
        for (int i = 0; i < 7; i++) {

            total += rainfall[i];

            if (rainfall[i] > max) {

                max = rainfall[i];

                wettestDay = i + 1;
            }

            if (rainfall[i] == 0) {

                dryDays++;
            }
        }

        double average = total / 7;

        // Print daily rainfall
        System.out.println("\nDaily Rainfall:");

        for (int i = 0; i < 7; i++) {

            System.out.printf("Day %d: %.1f mm%n",
                    i + 1, rainfall[i]);
        }

        System.out.printf("Total Rainfall: %.1f mm%n", total);

        System.out.printf("Average Rainfall: %.2f mm%n", average);

        System.out.printf("Wettest Day: Day %d (%.1f mm)%n",
                wettestDay, max);

        System.out.println("Total Dry Days: " + dryDays);

        sc.close();
    }
}
