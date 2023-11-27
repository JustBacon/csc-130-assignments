// Christian Buco
// Assignment 4
// CSC 130-05

// Program will ask for text file to open the file
// prints a two-column table consisting of all the words in the file
// with the number of times that each word appears

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class assignment4 {

    // function that will go through the file and get all the words and the frequency
    public static Map<String, Integer> countWordFrequency(String filePath) throws IOException {
        // initialize hashmap of String, Integer
        Map<String, Integer> wordFrequency = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        // while loop to go through the whole file
        while ((line = reader.readLine()) != null) {
            // split the line of words into an array of words
            String[] words = line.split("\\s+");

            // for loop in array and change it to lowercase
            for (String word : words) {
                // Remove punctuation marks from the word
                word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

                // if there is a word, put into hashmap with default value of (0 or currentvalue) + 1
                if (!word.isEmpty()) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        }

        reader.close();
        return wordFrequency;
    }

    // display the hashmap in 2 column
    public static void displayWordFrequency(Map<String, Integer> wordFrequency) {
        // put into an array to sort it
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordFrequency.entrySet());
        sortedList.sort(Map.Entry.comparingByKey());

        System.out.println("Word\t\tFrequency");
        System.out.println("---------------------");

        // loops array and print out the word and frequency
        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.printf("%-16s%d\n", entry.getKey(), entry.getValue());
        }
    }
    // The main (The driver)
    public static void main(String[] args) {
        // Ask user for filepath
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        // trycatch in case file does not exist
        try {
            // use hashmap for (string as key) (frequency as frequency)
            // display results after
            Map<String, Integer> wordFrequency = countWordFrequency(filePath);
            displayWordFrequency(wordFrequency);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
