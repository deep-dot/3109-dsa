package w4.linkedStack;

public class LinkedStack<T> {
    private Node<T> top; // top of stack (head)
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    // push: add to top
    public void push(T value) {
        top = new Node<>(value, top); // new node points to old top
        size++;
    }

    // pop: remove and return top
    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack underflow");
        T val = top.data;
        Node<T> oldTop = top;
        top = top.next;         // drop first node
        oldTop.next = null;     // help GC (optional)
        size--;
        return val;
    }

    // peek: read top without removing
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return top.data;
    }

    public boolean isEmpty() { return top == null; }
    public int size()        { return size; }

    public void clear() {     // O(n)
        while (top != null) {
            Node<T> nxt = top.next;
            top.next = null;  // help GC
            top = nxt;
        }
        size = 0;
    }

    public void printStack() {
        if (isEmpty()) { System.out.println("Stack is empty"); return; }
        System.out.print("Stack (top→down): ");
        for (Node<T> cur = top; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println();
    }
}
