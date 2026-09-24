import java.util.Scanner;

public class Problem4 {

    private static double rowAverage(int[] row) {

        int sum = 0;

        for (int value : row) {
            sum += value;
        }

        return (double) sum / row.length;
    }

    static String classifyRows(
            int[][] runsPerOver,
            int threshold) {

        String result = "";

        for (int i = 0; i < runsPerOver.length; i++) {

            double average = rowAverage(runsPerOver[i]);

            String status;

            if (average >= threshold) {
                status = "Power Surge";
            } else {
                status = "Normal";
            }

            if (i > 0) {
                result += " | ";
            }

            result += "Match " + i + ": " + status;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of matches: ");
        int matches = sc.nextInt();

        int[][] runsPerOver = new int[matches][];

        for (int i = 0; i < matches; i++) {

            System.out.print(
                    "Enter number of overs for Match "
                    + i + ": ");

            int overs = sc.nextInt();

            runsPerOver[i] = new int[overs];

            System.out.println("Enter runs:");

            for (int j = 0; j < overs; j++) {
                runsPerOver[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter threshold: ");
        int threshold = sc.nextInt();

        System.out.println(
                classifyRows(runsPerOver, threshold));

        sc.close();
    }
}