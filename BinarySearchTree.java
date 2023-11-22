class BinarySearchTree implements DataStructure {
    // Node class for BST
    private class Node {
        String key;
        Node left, right;

        // Node constructor
        public Node(String key) {
            this.key = key;
            left = right = null;
        }
    }

    private Node root;

    //BST constructor
    public BinarySearchTree() {
        root = null;
    }

    /*
     * This function calls insertRec to add
     * a new node to the BST
     */
    public void insert(String key) {
        root = insertRec(root, key);
    }

    /*
     * This function searches through the tree to
     * find the correct place for the given key
     */
    private Node insertRec(Node root, String key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key.compareTo(root.key) < 0) {
            root.left = insertRec(root.left, key);
        } else if (key.compareTo(root.key) > 0) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    /*
     * This function calls searchRec to
     * search for a specified key in the BST
     */
    public boolean search(String key) {
        return searchRec(root, key);
    }

    /*
     * This functions searches through the tree trying
     * to find the given key. Returns true or false
     * depending on if the search was successful or not.
     */
    private boolean searchRec(Node root, String key) {
        if (root == null || key.equals(root.key)) {
            return root != null;
        }

        if (key.compareTo(root.key) < 0) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }
}