import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class assignment4 {
    public static void main(String[] args) {
        // Ask user for filepath
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        // trycatch in case file does not exist
        try {
            Map<String, Integer> wordFrequency = countWordFrequency(filePath);
            displayWordFrequency(wordFrequency);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public static Map<String, Integer> countWordFrequency(String filePath) throws IOException {
        Map<String, Integer> wordFrequency = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");

            for (String word : words) {
                // Remove punctuation marks from the word
                word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

                if (!word.isEmpty()) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        }

        reader.close();
        return wordFrequency;
    }

    public static void displayWordFrequency(Map<String, Integer> wordFrequency) {
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordFrequency.entrySet());
        sortedList.sort(Map.Entry.comparingByKey());

        System.out.println("Word\t\tFrequency");
        System.out.println("---------------------");

        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.printf("%-15s%d\n", entry.getKey(), entry.getValue());
        }
    }
}
