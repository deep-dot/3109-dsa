class Node {
    int key;
    Node left, right;

    public Node(int key) {
        this.key = key;
        left = right = null;
    }
}

public class BSTSearch {

    // Search for a key starting from given root
    public static boolean search(Node root, int key) {
        if (root == null) return false;         // empty tree
        if (root.key == key) return true;       // found!
        if (key < root.key) 
            return search(root.left, key);      // search left subtree
        else
            return search(root.right, key);     // search right subtree
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        System.out.println("Search 40: " + search(root, 40)); // true
        System.out.println("Search 25: " + search(root, 25)); // false
    }
}
