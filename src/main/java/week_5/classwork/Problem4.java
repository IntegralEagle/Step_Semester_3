public class Problem4 {

    static double rowAverage(int[] row) {

        int sum = 0;

        for (int value : row) {
            sum += value;
        }

        return (double) sum / row.length;
    }

    static String classifyRow(int[] row, int threshold) {

        double average = rowAverage(row);

        if (average > threshold) {
            return "Quiet Zone";
        } else {
            return "Buzzing Zone";
        }
    }

    static String classifyRows(int[][] seatingScores, int threshold) {

        String result = "";

        for (int i = 0; i < seatingScores.length; i++) {

            String zone = classifyRow(seatingScores[i], threshold);

            if (i > 0) {
                result += " | ";
            }

            result += "Row " + i + ": " + zone;
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] seatingScores = {
            {48, 50, 45},
            {40, 80, 45},
            {35, 30, 25}
        };

        int threshold = 60;

        System.out.println(
            classifyRows(seatingScores, threshold)
        );
    }
}