public class LinkedQueue<T> {
    private Node<T> front;  // points to first element
    private Node<T> rear;   // points to last element
    private int size;

    public LinkedQueue() {
        front = rear = null;
        size = 0;
    }

    // Enqueue: add element at rear
    public void enqueue(T value) {
        Node<T> newNode = new Node<T>(value);
        if (rear == null) {       // queue is empty
            front = rear = newNode;
        } else {
            rear.next = newNode;  // link old rear to new
            rear = newNode;       // update rear
        }
        size++;
    }

    // Dequeue: remove element from front
    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue underflow");
        T value = front.data;
        front = front.next;
        if (front == null) {   // if queue became empty
            rear = null;
        }
        size--;
        return value;
    }

    // Peek: look at front without removing
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return front.data;
    }

    public boolean isEmpty() { return front == null; }
    public int size() { return size; }

    public void printQueue() {
        if (isEmpty()) { 
            System.out.println("Queue is empty"); 
            return; 
        }
        System.out.print("Queue: ");
        Node<T> current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
