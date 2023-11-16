import java.util.ArrayList;
import java.util.List;

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    // Individual Node constructer
    public TrieNode() {
        this.children = new TrieNode[26]; // Assuming the characters are in lowercase English letters
        this.isEndOfWord = false;
    }
}

public class Trie implements DataStructure {
    private TrieNode root;
    // Trie constructer
    public Trie() {
        this.root = new TrieNode();
    }

    /*
     * insert(word) takes a string and inserts it
     * into the Trie while maintaining alphabetical
     * order.
     * Runtime: O(n)
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a'; // Assuming the characters are in lowercase English letters
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    /*
     * search(word) takes a string and searches the
     * Trie to see if the word is inside the Trie.
     * Returns: boolean; whether the seach was successful
     * Runtime: O(n)
     */
    public boolean search(String word) {
        TrieNode node = root;
        System.out.println("searching Trie...");
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a'; // Assuming the characters are in lowercase English letters
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node != null && node.isEndOfWord;
    }

    /*
     * startsWith(prefix) is given a small string
     * and checks if it is inside of the Trie.
     * Returns: boolean; whether the seach was successful
     * Runtime: O(n)
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a'; // Assuming the characters are in lowercase English letters
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node != null;
    }

    /*
     * findWordsWithPrefix(prefix) finds all words
     * in the Trie that match the given prexic.
     * Returns; List<String>; words with given prefix.
     * Runtime: TODO
     */
    public List<String> findWordsWithPrefix(String prefix) {
        List<String> words = new ArrayList<>();
        TrieNode node = findNodeWithPrefix(prefix);
        if (node != null) {
            findWords(node, prefix, words);
        }
        return words;
    }

    /*
     * findNodeWithPrefix(prefix) finds a node that
     * matches the given prefix. Used to help funciton
     * findWordsWithPrefix(prefix).
     * Returns: TrieNode, A node that matches the prefix
     * Runtime: O(n)
     */
    private TrieNode findNodeWithPrefix(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a'; // Assuming the characters are in lowercase English letters
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    /*
     * findWords(node,currentWord,words) is given a starting point via
     * a node, and a string to build off of. It finds all the words in 
     * the Trie that start with currentWord. words is updated every time
     * another valid word is found.
     * Runtime: TODO
     */
    private void findWords(TrieNode node, String currentWord, List<String> words) {
        if (node.isEndOfWord) {
            words.add(currentWord);
        }
        for (int i = 0; i < 26; i++) {
            TrieNode child = node.children[i];
            if (child != null) {
                char ch = (char) (i + 'a');
                findWords(child, currentWord + ch, words);
            }
        }
    }

}