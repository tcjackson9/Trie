class BinarySearchTree implements DataStructure {
    private class Node {
        String key;
        Node left, right;

        public Node(String key) {
            this.key = key;
            left = right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(String key) {
        root = insertRec(root, key);
    }

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

    public boolean search(String key) {
        return searchRec(root, key);
    }

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