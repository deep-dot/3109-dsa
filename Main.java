public class Main { 

    public static void main(String[] args) {
        int num = 1000000;
        long start = System.currentTimeMillis();   
       for (int i = 2; i < num; i++) {
            if (prime(i)) {
                System.out.print(i + " ");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(); // newline after the list
        System.out.println("start:   " + start);
        System.out.println("end:     " + end);
        System.out.println("elapsed: " + (end - start) + " ms");
    }
    public static Boolean prime(int num) {

        int limit = (int)Math.sqrt(num) + 1;
        for (int i = 2; i < limit; i++) {
            if (num % i  == 0) {                                
                return false;
            }            
        }
        return true;
    }
}