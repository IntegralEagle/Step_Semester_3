import java.util.Arrays;

public class Problem5 {

    static class Candidate implements Comparable<Candidate> {

        String name;
        double cgpa;
        int codingScore;

        Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        static boolean isEligible(double cgpa) {
            return cgpa >= 7.5;
        }

        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }

        double getCompositeScore() {
            return cgpa * 10 + codingScore;
        }

        @Override
        public int compareTo(Candidate other) {

            return Double.compare(
                other.getCompositeScore(),
                this.getCompositeScore()
            );
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {

        int count = 0;

        for (Candidate candidate : candidates) {

            if (Candidate.isEligible(candidate.cgpa)
                    || Candidate.isEligible(
                        candidate.cgpa,
                        candidate.codingScore)) {

                count++;
            }
        }

        Candidate[] shortlisted = new Candidate[count];

        int index = 0;

        for (Candidate candidate : candidates) {

            if (Candidate.isEligible(candidate.cgpa)
                    || Candidate.isEligible(
                        candidate.cgpa,
                        candidate.codingScore)) {

                shortlisted[index] = candidate;
                index++;
            }
        }

        Arrays.sort(shortlisted);

        String result = "";

        for (int i = 0; i < shortlisted.length; i++) {

            if (i > 0) {
                result += " | ";
            }

            result += (i + 1)
                    + ". "
                    + shortlisted[i].name
                    + " ("
                    + shortlisted[i].getCompositeScore()
                    + ")";
        }

        return result;
    }

    public static void main(String[] args) {

        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 48),
            new Candidate("Rohit", 8.5, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}