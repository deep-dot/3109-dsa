// Task 1. Let F be the sequence defined by the following recursive formula:
// F(0) = 1, F(1) = 1, F(2) = 1
// F(n) = 2*F(n - 1) + F(n - 2) - F(n - 3) , if n > 2
// (a) Write a recursive function/method long F(int n), that returns F(n) for n >= 0, and returns -1 for n < 0.
// (b) Compute the first 10 values of the sequence.

// public class sampleTest1 {
//     public static void main(String[] args){
//         int n = 10;
//         for (int i=0; i<n; i++){
//             System.out.println(recMethod(i));
//         }        
//     }
//     public static int recMethod(int n){
//         if(n <= 2){
//             return 1;
//         } else {
//                 return 2 * recMethod(n-1)+ recMethod(n-2) - recMethod(n-3);
//         }
//     }

// }

public class sampleTest1 {
    static long calls;

    public static void main(String[] args) {
        int n = 1;
        int i = 4;
        calls = 0;
        // for (int i = 0; i <= 10; i++) {
        System.out.println(f(i, n) + ", " + calls);
        // }
    }

    public static int f(int i, int n) {
        calls++;
        if (i == 0) {
            return n + 1;
        } else {
            if (i > 0 && n == 0) {
                return f(i - 1, 1);
            } else {
                return f(i - 1, f(i, n - 1));
            }
        }
    }
}
