
import java.util.*;

public class WordFrequency {
    static void printFilteredWordFrequency(String feedback) {
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        feedback = feedback.toLowerCase();
        feedback = feedback.replace(".", "").replace(",", "");

        String[] words = feedback.trim().split("\\s+");

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }

            boolean isStopWord = false;

            for (String stop : stopWords) {
                if (word.equals(stop)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }

        ArrayList<String> sortedWords = new ArrayList<>(frequency.keySet());

        sortedWords.sort((a, b) -> Integer.compare(frequency.get(b), frequency.get(a)));

        for (String word : sortedWords) {
            System.out.println(word + ": " + frequency.get(word));
        }
    }

    public static void main(String[] args) {
        String feedback = "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}
