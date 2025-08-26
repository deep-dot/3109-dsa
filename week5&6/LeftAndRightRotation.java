// No package line, so you can compile/run easily

class Node {
    int key;
    Node left, right;

    public Node(int key) {
        this.key = key; //
        left = right = null;
    }
}

public class LeftAndRightRotation {

    // Right rotation
    public static Node right(Node root) {
        if (root == null || root.left == null) return root;

        Node formerRoot = root;
        Node newRoot = root.left;
        // Perform rotation
        formerRoot.left = newRoot.right;
        newRoot.right = formerRoot;

        return newRoot; // return new root after rotation
    }

    //left rotation
    public static Node left(Node root) {
    	 if (root == null || root.left == null) return root;
    	 Node formerRoot = root;
    	 Node newRoot = root.right;
    	formerRoot.right = newRoot.left;
    	newRoot.left = formerRoot;
    	return newRoot;
    }
    // Inorder traversal
    public static void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(30);
        root.left = new Node(20);
        root.left.left = new Node(10);

        System.out.println("Before right rotation (inorder):");
        inorder(root);
        System.out.println();

        root = right(root);

        System.out.println("After right rotation (inorder):");
        inorder(root);
        System.out.println();

        root = left(root);

        System.out.println("After left rotation (inorder):");
        inorder(root);
        System.out.println();
    }
}
