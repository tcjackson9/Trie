import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class WordSearch {
    private static Trie trie;

    public static void main(String[] args) {
        trie = new Trie();
        try (BufferedReader br = new BufferedReader(new FileReader("words_alpha.txt"))) {
            String word;
            while ((word = br.readLine()) != null) {
                trie.insert(word.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    findWordsWithPrefix();
                    break;
                case 2:
                    insertNewWord();
                    break;
                case 3:
                    searchForCompleteWord();
                    break;
                case 4:
                    removeWord();
                    break;
                case 5:
                    displayTrieStructure();
                    break;
                case 6:
                    measurePerformance();
                    break;
                case 7:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Find words with prefix");
        System.out.println("2. Insert a new word");
        System.out.println("3. Search for complete word");
        System.out.println("4. Remove a word");
        System.out.println("5. Display Trie structure");
        System.out.println("6. Measure performance");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return Integer.parseInt(reader.readLine().trim());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return getUserChoice();
        }
    }

    private static void insertNewWord() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a new word to insert: ");
            String newWord = reader.readLine().trim();

            if (newWord.isEmpty() || !newWord.matches("[a-zA-Z]+")) {
                System.out.println("Invalid word. Please enter a valid alphabetical word.");
                return;
            }

            trie.insert(newWord);
            System.out.println("Word '" + newWord + "' successfully inserted into the trie.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void searchForCompleteWord() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a word to search for: ");
            String searchWord = reader.readLine().trim();

            if (searchWord.isEmpty() || !searchWord.matches("[a-zA-Z]+")) {
                System.out.println("Invalid word. Please enter a valid alphabetical word.");
                return;
            }
            if (trie.search(searchWord)) {
                System.out.println("The word '" + searchWord + "' is present in the trie.");
            } else {
                System.out.println("The word '" + searchWord + "' is not present in the trie.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void removeWord() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a word to remove: ");
            String removeWord = reader.readLine().trim();

            if (removeWord.isEmpty() || !removeWord.matches("[a-zA-Z]+")) {
                System.out.println("Invalid word. Please enter a valid alphabetical word.");
                return;
            }

            if (trie.remove(removeWord)) {
                System.out.println("Word '" + removeWord + "' successfully removed from the trie.");
            } else {
                System.out.println("The word '" + removeWord + "' is not present in the trie.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void findWordsWithPrefix() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a prefix: ");
            String prefix = reader.readLine().trim();

            if (prefix.isEmpty()) {
                System.out.println("Prefix cannot be empty. Please enter a valid prefix.");
                return;
            }

            if (!prefix.matches("[a-zA-Z]+")) {
                System.out.println("Invalid characters in the prefix. Please enter only alphabetical characters.");
                return;
            }

            List<String> words = trie.findWordsWithPrefix(prefix);
            if (words.isEmpty()) {
                System.out.println("No words found with the prefix '" + prefix + "'.");
            } else {
                System.out.println("Words starting with '" + prefix + "': ");
                for (String word : words) {
                    System.out.println(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayTrieStructure() {
        System.out.println("Trie Structure:\n" + trie.toString());
    }

    private static void measurePerformance() {
        long startTime = System.nanoTime();
        // Perform some operations to measure performance
        long endTime = System.nanoTime();
        System.out.println("Performance Measurement: " + (endTime - startTime) + " ns");
    }
}
