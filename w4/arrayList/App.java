

public class App {
    public static void main(String[] args) throws Exception {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        
        list.printList(); // Apple Banana Cherry 

        System.out.println("Element at index 1: " + list.get(1)); // Banana
        
        list.remove(1); 
        list.printList(); // Apple Cherry
    }
}
