public class week2 {
    
    public static void main(String[] args) {
        int n = 10, i=1;
        for(; i<n; i++){
            System.out.println(fib_mem(i));
        }        
    }
    public static long fib_mem(int n) {
    long[] f = new long[n];              // all zeros initially
    long result = fib_mem_helper(n, f);
    return result;
}
public static long fib_mem_helper(int n, long[] f) {
    if (n == 1 || n == 2) {
        f[n - 1] = 1;
    } else {
        if (f[n - 1] == 0) {
            f[n - 1] = fib_mem_helper(n - 2, f) + fib_mem_helper(n - 1, f);
        }
    }
    return f[n - 1];
}

}
