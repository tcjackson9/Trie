
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TrieVsHashtableComparison {
    public static void main(String[] args) {
        ArrayList<String> ar = new ArrayList<String>();
        Trie trie = new Trie();
        HashTable hashtable = new HashTable();

        // Insertion
        long startInsertionTimeTrie = System.nanoTime();
        performInsertions(trie,ar);
        long endInsertionTimeTrie = System.nanoTime();
        ar = new ArrayList<String>();
        long startInsertionTimeHashtable = System.nanoTime();
        performInsertions(hashtable,ar);
        long endInsertionTimeHashtable = System.nanoTime();

        // Search
        long startSearchTimeTrie = System.nanoTime();
        performSearches(trie, ar);
        long endSearchTimeTrie = System.nanoTime();

        long startSearchTimeHashtable = System.nanoTime();
        performSearches(hashtable, ar);
        long endSearchTimeHashtable = System.nanoTime();


        // Calculate and print time taken for each operation
        System.out.println("Insertion time in Trie: " + (endInsertionTimeTrie - startInsertionTimeTrie) + " ns");
        System.out.println("Insertion time in Hashtable: " + (endInsertionTimeHashtable - startInsertionTimeHashtable) + " ns");

        System.out.println("Search time in Trie: " + (endSearchTimeTrie - startSearchTimeTrie) + " ns");
        System.out.println("Search time in Hashtable: " + (endSearchTimeHashtable - startSearchTimeHashtable) + " ns");


        // Print space complexity
        System.out.println("Space complexity of Trie: " + calculateSpaceComplexity(trie) + " bytes");
        System.out.println("Space complexity of Hashtable: " + calculateSpaceComplexity(hashtable) + " bytes");
    }

    // Helper method to perform insertions
    private static void performInsertions(DataStructure ds, ArrayList<String> ar) {
        try (BufferedReader br = new BufferedReader(new FileReader("words_alpha.txt"))) {
            String word;
            int i = 1;
            int n = 10000;
            while (i <= n && (word = br.readLine()) != null) {
                ds.insert(word.trim());
                ar.add(word.trim());
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to perform searches
    private static void performSearches(DataStructure ds, ArrayList<String> ar) {
        for (int i = 0; i < ar.size(); i++) {
            ds.search(ar.get(i));
        }
    }


    private static long calculateSpaceComplexity(DataStructure ds) {
        // This is a rough estimation and may not be accurate depending on the implementation
        // For more accurate measurement, you might want to use a memory profiler tool
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }
}