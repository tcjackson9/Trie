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

        findWordsWithPrefix();
    }

    private static void findWordsWithPrefix() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a prefix: ");
            String prefix = reader.readLine();

            List<String> words = trie.findWordsWithPrefix(prefix);
            System.out.println("Words starting with '" + prefix + "': ");
            for (String word : words) {
                System.out.println(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}