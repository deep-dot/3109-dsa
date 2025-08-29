package assignment1;

import java.util.Arrays;

public class Task1_2 {

    private static boolean nextPermutation(int[] a) {
        int len = a.length;
        int start = 0;

        if (len <= 1) return false;
        int timesOfMaxAtFront = -1;  

        while (true) {
            int pos = posOfMaxNum(a, start, len);

            if (pos > start) {
                swap(a, pos, pos - 1);
                for (int s = timesOfMaxAtFront; s >= 0; s--) {
                    moveLeftByOne(a, s, a.length - s);
                }
                return true;
            }

            if (len == 1) return false;

            timesOfMaxAtFront++;         // pushing a frame
            start += 1;
            len   -= 1;
        }
    }

    // Return the index of the maximum element within window [start, start+len)
    private static int posOfMaxNum(int[] a, int start, int len) {
        int pos = start;
        int max = a[start];
        for (int i = start + 1; i < start + len; i++) {
            if (a[i] > max) {
                max = a[i];
                pos = i;
            }
        }
        return pos;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // Move a[start] to end of the window [start, start+len), shifting others left by 1
    private static void moveLeftByOne(int[] a, int start, int len) {
        int first = a[start];
        for (int i = start; i < start + len - 1; i++) {
            a[i] = a[i + 1];
        }
        a[start + len - 1] = first;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        do {
            System.out.println(Arrays.toString(a));
        } while (nextPermutation(a));
        System.out.println("No further permutations.");
    }
}
