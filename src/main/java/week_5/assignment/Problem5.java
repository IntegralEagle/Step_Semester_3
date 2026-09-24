import java.util.Arrays;

public class Problem5 {

    static class Player implements Comparable<Player> {

        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        // Constructor
        public Player(
                String name,
                int matchesPlayed,
                double battingAverage,
                boolean injured) {

            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        // Eligibility rule 1:
        // Experienced players need 10 or more matches.
        static boolean isDraftable(int matchesPlayed) {

            return matchesPlayed >= 10;
        }

        // Eligibility rule 2:
        // Newer players need enough matches,
        // good batting average and must not be injured.
        static boolean isDraftable(
                int matchesPlayed,
                double battingAverage,
                boolean injured) {

            return matchesPlayed >= 5
                    && battingAverage >= 50
                    && !injured;
        }

        // compareTo decides ranking.
        // Higher batting average comes first.
        @Override
        public int compareTo(Player other) {

            return Double.compare(
                    other.battingAverage,
                    this.battingAverage);
        }

        public String getName() {
            return name;
        }
    }

    static String draftAndRank(Player[] players) {

        // Count draftable players first
        int count = 0;

        for (Player player : players) {

            if (Player.isDraftable(player.matchesPlayed)
                    || Player.isDraftable(
                            player.matchesPlayed,
                            player.battingAverage,
                            player.injured)) {

                count++;
            }
        }

        // Create array only for draftable players
        Player[] draftable = new Player[count];

        int index = 0;

        for (Player player : players) {

            if (Player.isDraftable(player.matchesPlayed)
                    || Player.isDraftable(
                            player.matchesPlayed,
                            player.battingAverage,
                            player.injured)) {

                draftable[index] = player;
                index++;
            }
        }

        // Uses Player.compareTo()
        Arrays.sort(draftable);

        String result = "";

        for (int i = 0; i < draftable.length; i++) {

            if (i > 0) {
                result += " | ";
            }

            result += (i + 1)
                    + ". "
                    + draftable[i].getName();
        }

        return result;
    }

    public static void main(String[] args) {

        Player[] players = {

            new Player("Virat", 15, 48.0, false),

            new Player("Rahul", 7, 55.0, false),

            new Player("Sameer", 3, 60.0, false),

            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(
                draftAndRank(players));
    }
}