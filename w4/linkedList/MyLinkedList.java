// package w4.linkedList;

// public class MyLinkedList<T> {
//     private Node<T> head; // first node
//     private int size;

//     public MyLinkedList() {
//         head = null;
//         size = 0;
//     }

//     // Add element at end
//     public void add(T value) {
//         Node<T> newNode = new Node<>(value);
//         if (head == null) {
//             head = newNode;
//         } else {
//             Node<T> current = head;
//             while (current.next != null) {
//                 current = current.next;
//             }
//             current.next = newNode;
//         }
//         size++;
//     }

//     // Get element by index
//     public T get(int index) {
//         checkIndex(index);
//         Node<T> current = head;
//         for (int i = 0; i < index; i++) {
//             current = current.next;
//         }
//         return current.data;
//     }

//     // Remove element by index
//     public void remove(int index) {
//         checkIndex(index);
//         if (index == 0) {
//             head = head.next;
//         } else {
//             Node<T> current = head;
//             for (int i = 0; i < index - 1; i++) {
//                 current = current.next;
//             }
//             current.next = current.next.next;
//         }
//         size--;
//     }

//     // Current size
//     public int size() {
//         return size;
//     }

//     // Print all elements
//     public void printList() {
//         Node<T> current = head;
//         while (current != null) {
//             System.out.print(current.data + " ");
//             current = current.next;
//         }
//         System.out.println();
//     }

//     // Check valid index
//     private void checkIndex(int index) {
//         if (index < 0 || index >= size) {
//             throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
//         }
//     }
// }

public class MyLinkedList<T> {

    private Node<T> head;
    private int size;

    public MyLinkedList(){
        head = null;
        size = 0;
    }

    public void printList(){
        Node<T> current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void deleteList(){
        head = null;
        size = 0;
    }

    public void deleteFirst(){
        if(head == null){
            throw new RuntimeException();
        }
        head = head.next;
        size--;
    }

    public void deleteLast(){
        if(head == null){
            throw new RuntimeException();
        }
        Node<T> current = head;
        while(current.next.next != null){
            current = current.next;
        }
        current.next = null;
        size--;
    }

    public void deleteIndex(int index){
        Node<T> current = head;
        for(int i = 0 ; i < index ; i--){
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    public T get(int index){
        Node<T> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }

    public void addElement(T v){
        Node<T> newNode = new Node<>(v);
        if(head == null){
            head = newNode;
        } else {
            Node<T> current = head;
            while(current.next != null){
                    current = current.next;
            }
            current.next = newNode;
            size++;
        }

    }
}