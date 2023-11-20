import java.util.ArrayList;
import java.util.List;

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    // Individual Node constructor
    public TrieNode() {
        this.children = new TrieNode[26]; // Assuming the characters are in lowercase English letters
        this.isEndOfWord = false;
    }
}

public class Trie implements DataStructure {
    private TrieNode root;

    // Trie constructor
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
     * search(word, caseSensitive) takes a string and searches the
     * Trie to see if the word is inside the Trie. It supports
     * case-sensitive and case-insensitive searches based on the
     * value of the caseSensitive parameter.
     * Returns: boolean; whether the search was successful
     * Runtime: O(n)
     */
    public boolean search(String word) {
        TrieNode node = root;
        System.out.println("searching Trie...");
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = getIndex(c);
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node != null && node.isEndOfWord;
    }

    /*
     * startsWith(prefix) is given a small string
     * and checks if it is inside the Trie.
     * Returns: boolean; whether the search was successful
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
     * in the Trie that match the given prefix.
     * Returns: List<String>; words with given prefix.
     * Runtime: O(k + m), where k is the length of the prefix and m is the total number of nodes in the sub-trie.
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
     * matches the given prefix. Used to help function
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
     * findWords(node, currentWord, words) is given a starting point via
     * a node, and a string to build off of. It finds all the words in
     * the Trie that start with currentWord. words are updated every time
     * another valid word is found.
     * Runtime: O(m), where m is the total number of nodes in the sub-trie.
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

    /*
     * remove(word) removes a word from the Trie.
     * Returns: boolean; whether the removal was successful
     * Runtime: O(n)
     */
    public boolean remove(String word) {
        return remove(root, word, 0);
    }

    private boolean remove(TrieNode node, String word, int depth) {
        if (node == null) {
            return false;
        }

        if (depth == word.length()) {
            if (!node.isEndOfWord) {
                return false;
            }
            node.isEndOfWord = false;

            // If the current node has no other children, it can be safely removed
            return isNodeEmpty(node);
        }

        char c = word.charAt(depth);
        int index = c - 'a';

        if (remove(node.children[index], word, depth + 1)) {
            node.children[index] = null;
            return !node.isEndOfWord && isNodeEmpty(node);
        }

        return false;
    }

    private boolean isNodeEmpty(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }

    private int getIndex(char c) {
        return Character.toLowerCase(c) - 'a';
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        displayTrieStructure(root, "", sb);
        return sb.toString();
    }

    private void displayTrieStructure(TrieNode node, String currentPrefix, StringBuilder sb) {
        if (node.isEndOfWord) {
            sb.append(currentPrefix).append("\n");
        }
        for (int i = 0; i < 26; i++) {
            TrieNode child = node.children[i];
            if (child != null) {
                char ch = (char) (i + 'a');
                displayTrieStructure(child, currentPrefix + ch, sb);
            }
        }
    }
}
