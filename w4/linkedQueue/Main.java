public class Main {
    public static void main(String[] args) {
        LinkedQueue<Integer> q = new LinkedQueue<>();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.printQueue();       // Queue: 10 20 30

        System.out.println("Dequeued: " + q.dequeue()); // 10
        q.printQueue();       // Queue: 20 30

        System.out.println("Peek: " + q.peek()); // 20
        System.out.println("Size: " + q.size()); // 2
    }
}
