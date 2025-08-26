

class Node {
    int key;
    Node left, right;
    public Node(int key) {
        this.key = key;
        left = right = null;
    }
}

public class RootInsert {

    // Tree root
    private static Node root = null;

    // Insert a node into the BST; returns (possibly new) root
    public static Node insert(Node node) {
        root = insertRec(root, node);
        return root;
    }

    private static Node insertRec(Node curr, Node node) {
        if (curr == null) return node;

        if (node.key < curr.key) {
            curr.left = insertRec(curr.left, node);
        } else if (node.key > curr.key) {
            curr.right = insertRec(curr.right, node);
        } // else: duplicate key -> ignore (or handle as you wish)

        return curr;
    }

    // Inorder traversal
    public static void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private static void inorderRec(Node n) {
        if (n == null) return;
        inorderRec(n.left);
        System.out.print(n.key + " ");
        inorderRec(n.right);
    }

    public static void main(String[] args) {
        // Build the tree using insert (don’t hand-wire children)
        insert(new Node(10));
        insert(new Node(20));
        insert(new Node(30));
        insert(new Node(40));
        insert(new Node(5));
        insert(new Node(25));

        System.out.print("Inorder: ");
        inorder(); // -> 5 10 20 25 30 40
    }
}
