package assignment1;

import java.util.Arrays;

public class Task1_3 {

    private static boolean nextPermutationIter(int[] a) {
        int len = a.length;
        int start = 0;

        // if array size is 1 or less than there is not permutation
        if (len <= 1) return false;
        int timesOfMaxAtFront = -1; //assumed how many times max number is occuring at start position.

        while (true) { // this condition will remain true until array length is 1
            int pos = posOfMaxNum(a, start, len);// find position of maximum number in array.

         // Case 1: max not at front, swap it one step left
            if (pos > start) {
                swap(a, pos, pos - 1);// If the maximum is not at the first position, swap it with its left neighbour and return.
                for (int s = timesOfMaxAtFront; s >= 0; s--) {
                    moveLeftByOne(a, s, a.length - s);// will work only if max number is reached at first position or tail array's big number reached at first position
                }
                return true;
            }

            if (len == 1) return false;
           
         // Case 2: max at front position then all vaues are updated. 
            //And If the maximum is at the first position, shrink the array by moving its start right by one.
            timesOfMaxAtFront++;         
            start += 1;
            len   -= 1;
        }
    }

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

    // Move a[start] to end of the array, shifting others left by 1
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
        } while (nextPermutationIter(a));
        System.out.println("No further permutations.");
    }
}












