
public class ClassAttendance {

    static void attendanceSummary(int[] days) {
        int present = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                present++;
                currentStreak++;

                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        System.out.println("Present: " + present);
        System.out.println("Longest streak: " + longestStreak);
    }

    public static void main(String[] args) {
        int[] days1 = {1, 1, 0, 1, 1, 1, 0, 1};
        attendanceSummary(days1);

        System.out.println();

        int[] days2 = {0, 0, 0};
        attendanceSummary(days2);
    }
}
