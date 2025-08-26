
class Node {
    int key;
    Node left, right;
    public Node(int key){
        this.key = key;
        left = right = null;
    }
}
public class AvlLRrotation {
    private static Node root = null;
    public static Node insert(Node curr){
        if(root == null) return root = curr;

        Node former = root;
        Node newRoot = root.left.right;
        root = newRoot;
        newRoot.left = former.left;
        newRoot.right = former.right;
        former.left.right = newRoot.left;
        former.left = newRoot.right;

        return newRoot;
    }
    public static void inorder(){
        inorderCall(root);
        System.out.println();
    }
    public static void inorderCall(Node root){
        if(root == null) return;
        inorderCall(root.left);
        System.out.println(root.key);
        inorderCall(root.right);
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
