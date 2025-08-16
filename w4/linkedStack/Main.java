package w4.linkedStack;

public class Main {
    public static void main(String[] args) {
        LinkedStack<String> s = new LinkedStack<>();
        s.push("A");
        s.push("B");
        s.push("C");
        s.printStack();              // Stack (top→down): C B A

        System.out.println(s.peek()); // C
        System.out.println(s.pop());  // C
        s.printStack();              // Stack (top→down): B A

        System.out.println("Size: " + s.size()); // 2
    }
}
