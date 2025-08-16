package w4.arrStack;

public class ArrStack {
    private int[] arr;   // storage
    private int top;     // index of the top element
    private int capacity;

    public ArrStack(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.top = -1; // empty stack
    }

    // push: add to top
    public void push(int value) {
        if (isFull()) throw new RuntimeException("Stack overflow");
        arr[++top] = value;
    }

    // pop: remove and return top
    public int pop() {
        if (isEmpty()) throw new RuntimeException("Stack underflow");
        return arr[top--];
    }

    // peek: read top without removing
    public int peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return arr[top];
    }

    public boolean isEmpty() { return top == -1; }
    public boolean isFull()  { return top == capacity - 1; }
    public int size()        { return top + 1; }

    public void printStack() {
        if (isEmpty()) { System.out.println("Stack is empty"); return; }
        System.out.print("Stack (bottom→top): ");
        for (int i = 0; i <= top; i++) System.out.print(arr[i] + " ");
        System.out.println();
    }
}

