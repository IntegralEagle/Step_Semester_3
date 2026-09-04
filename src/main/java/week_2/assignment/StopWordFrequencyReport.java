import java.util.*;

public class StopWordFrequencyReport {

    public static void printFilteredWordFrequency(String feedback) {

        Set<String> stopWords = new HashSet<>(
                Arrays.asList("the", "was", "and", "is", "of", "in")
        );

        String normalized = feedback
                .toLowerCase()
                .replace(".", "")
                .replace(",", "");

        String[] words = normalized.split("\\s+");

        Map<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            if (stopWords.contains(word)) {
                continue;
            }

            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());

        entries.sort((a, b) -> {
            int countCompare = Integer.compare(b.getValue(), a.getValue());

            if (countCompare != 0) {
                return countCompare;
            }

            return a.getKey().compareTo(b.getKey());
        });

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);

        sc.close();
    }
}