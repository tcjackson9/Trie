import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TrieVsHashtableVsBSTComparison {
    public static void main(String[] args) {
        ArrayList<String> wordsList = new ArrayList<>();
        Trie trie = new Trie();
        HashTable hashtable = new HashTable();
        BinarySearchTree bst = new BinarySearchTree();

        //Grab n value
        System.out.println("Enter a value for n");
        int n = getUserChoice();

        // Insertion
        long startInsertionTimeTrie = System.nanoTime();
        performInsertions(trie, wordsList,n);
        long endInsertionTimeTrie = System.nanoTime();

        wordsList = new ArrayList<>();
        long startInsertionTimeHashtable = System.nanoTime();
        performInsertions(hashtable, wordsList,n);
        long endInsertionTimeHashtable = System.nanoTime();

        wordsList = new ArrayList<>();
        long startInsertionTimeBST = System.nanoTime();
        performInsertions(bst, wordsList,n);
        long endInsertionTimeBST = System.nanoTime();

        // Search
        long startSearchTimeTrie = System.nanoTime();
        performSearches(trie, wordsList);
        long endSearchTimeTrie = System.nanoTime();

        long startSearchTimeHashtable = System.nanoTime();
        performSearches(hashtable, wordsList);
        long endSearchTimeHashtable = System.nanoTime();

        long startSearchTimeBST = System.nanoTime();
        performSearches(bst, wordsList);
        long endSearchTimeBST = System.nanoTime();

        // Calculate and print time taken for each operation
        System.out.println("Insertion time in Trie: " + (endInsertionTimeTrie - startInsertionTimeTrie) + " ns");
        System.out.println("Insertion time in Hashtable: " + (endInsertionTimeHashtable - startInsertionTimeHashtable) + " ns");
        System.out.println("Insertion time in BST: " + (endInsertionTimeBST - startInsertionTimeBST) + " ns");

        System.out.println("Search time in Trie: " + (endSearchTimeTrie - startSearchTimeTrie) + " ns");
        System.out.println("Search time in Hashtable: " + (endSearchTimeHashtable - startSearchTimeHashtable) + " ns");
        System.out.println("Search time in BST: " + (endSearchTimeBST - startSearchTimeBST) + " ns");

        // Print space complexity
        System.out.println("Space complexity of Trie: " + calculateSpaceComplexity(trie) + " bytes");
        System.out.println("Space complexity of Hashtable: " + calculateSpaceComplexity(hashtable) + " bytes");
        System.out.println("Space complexity of BST: " + calculateSpaceComplexity(bst) + " bytes");
    }

    // Helper method to perform insertions
    private static void performInsertions(DataStructure ds, ArrayList<String> wordsList,int n) {
        try (BufferedReader br = new BufferedReader(new FileReader("words_alpha.txt"))) {
            String word;
            int i = 1;
            while (i <= n && (word = br.readLine()) != null) {
                ds.insert(word.trim());
                wordsList.add(word.trim());
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to perform searches
    private static void performSearches(DataStructure ds, ArrayList<String> wordsList) {
        for (int i = 0; i < wordsList.size(); i++) {
            ds.search(wordsList.get(i));
        }
    }

    private static long calculateSpaceComplexity(DataStructure ds) {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
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
}