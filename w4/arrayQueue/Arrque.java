
public class Arrque {
    private int[] arr;       // array to store queue elements
    private int front;       // front points to the front element
    private int rear;        // rear points to the last element
    private int size;        // current size of the queue
    private int capacity;    // max capacity

    // Constructor
    public Arrque(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Add element to queue (enqueue)
    public void enqueue(int item) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        rear = (rear + 1) % capacity;  // circular increment
        arr[rear] = item;
        size++;
    }

    // Remove element from queue (dequeue)
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int item = arr[front];
        front = (front + 1) % capacity;  // circular increment
        size--;
        return item;
    }

    // Peek front element
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[front];
    }

    // Size of queue
    public int size() {
        return size;
    }

    // Check if empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if full
    public boolean isFull() {
        return size == capacity;
    }

    // Display queue
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}
