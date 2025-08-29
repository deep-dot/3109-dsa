package assignment1;

import java.util.Arrays;

public class Task1_2 {

    private static boolean nextPermutationIter(int[] a) {
        int len = a.length;
        int start = 0;

        // if array size is 1 or less than there is not permutation
        if (len <= 1) return false;
        int timesOfMaxAtFront = -1; //assumed how many times max number is occuring at start position.

        while (true) { // this condition will remain true until array length is 1
            int pos = posOfMaxNum(a, start, len);// find position of maximum number in array.

            if (pos > start) {
                swap(a, pos, pos - 1);// If the maximum is not at the first position, swap it with its left neighbour and return.
                for (int s = timesOfMaxAtFront; s >= 0; s--) {
                    moveLeftByOne(a, s, a.length - s);// will work only if max number is reached at first position
                }
                return true;
            }

            if (len == 1) return false;
           
            //when maximum number is equal to start position then all vaues are updated. 
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


//Implement an iterative version of thenext permutatio routine.
//
//In the current array, find the maximum element.
//If the maximum is not at the first position, swap it with its left neighbour and return.
//If the maximum is at the first position, shrink the window by moving its start right by one.
//Move a[start] to end of the array, shifting others left by 1

//'start, len' define the current array a[start .. start+len-1].
//'posOfMaxNum(a, start, len)' returns the index of the maximum inside that array.
//'timesOfMaxAtFront' counts how many times max number is occuring at start position.
//When we finally find a array where 'pos > start' (max not at front), we:
//
//  1. swap (pos, pos-1)`, and
//  2.sub array would be started to move left by one position and max number at first position will be appended at end of array.
//
//     for (int s = timesOfMaxAtFront; s >= 0; s--) {
//         moveLeftByOne(a, s, a.length - s);
//     }
//Time and Space Complexity
//  Finding the max can happen at up to O(n) with single for loop;
//  moving first element to end of array with single for loop is O(n) as well.

//Example Run (n = 3)
//
//Starting from [1, 2, 3], successive calls print:
//[1, 2, 3]
//[1, 3, 2]
//[3, 1, 2]
//[2, 1, 3]
//[2, 3, 1]
//[3, 2, 1]
//No further permutations.


//
//Task 1.2 — Inductive Proof of Correctness for nextPermutation
//1. If n == 1, return 'false.
//2. Let i be the position of the maximum element.
//
//   If i > 1 swap the maximum with its left neighbour and return true.
//   If i == 1 recursively call nextPermutation on the tail (positions 2..n).
//
//   If the recursive call returns true, left move the whole array by 1, move a1 to the end and return true.
//   If the recursive call returns false, return false.


//Proof by induction on n
//
//Base case (n = 1)
//There is only one permutation. The algorithm immediately returns false.
//Inductive hypothesis
//Assume for n − 1: for any permutation of size n−1, repeated calls to nextPermutation (on that tail) visit all (n−1)! permutations.
//
//Inductive step (from n−1 to n)
// Case A: The maximum is not in the first position (i > 1)
//
//The algorithm makes a single adjacent swap of the maximum with its left neighbour and returns true.
//This moves the maximum one position to the left.
//
//Case B: The maximum is in the first position (i = 1)
//
//If the largest element is already at the front, we temporarily ignore it and permuate the rest of the array.
//Each time the rest changes, move that front element to the end to make a new full-array permutation.
//Repeat this for every permutation of the rest. When the rest has no more, the algorithm finally returns false.
//
