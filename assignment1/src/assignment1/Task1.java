package assignment1;

import java.util.Arrays;

public class Task1 {

    public static boolean nextPermutation(int[] a) {
        return nextPermutation(a, 0, a.length);
    }

//    a recursive function 
//    named nextPermutation that generates the next permutation 
//    of a given sequence of integers. 
    private static boolean nextPermutation(int[] a, int start, int len) {
        if (len <= 1) return false; // no permutations for 0 and 1 element

        // Find the position 'pos' of the maximum element n 
        int n = len;
        int pos = -1;
        for (int k = 0; k < len; k++) {
            if (a[start + k] == n) { 
            	pos = start + k; 
            	break; 
            	}
        }

        if (pos != start) {
//        	Case 1: If the maximum element n is not in the first 
//        	position:
//        	• Swap ai  with ai-1. 
//        	• Return true to indicate that the next
            swap(a, pos, pos - 1);
            return true;
        }

//        Case 2: If the maximum element n is in the first 
//        position: 
//        • Recursively call nextPermutation on the 
//        subarray (a2,…,an), which represents a 
//        permutation of (n-1) elements. 
        boolean result = nextPermutation(a, start + 1, len - 1);
        if (!result) return false; // no further permutations

//      • If the recursive call returns true: 
//      • Append a1 to the resulting permutation 
//      of (n-1) elements. 
//      • If the recursive call returns false, indicate that no 
//      further permutations are available.
        
        moveLeftByOne(a, start, len);
        return true;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i]; 
        a[i] = a[j]; 
        a[j] = t;
    }

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
    }
}

/**
 * Advances the array to the NEXT permutation using the assignment's
 * recursive "max-at-front or swap-left" rule:
 *
 * Case 1: If the maximum element n in the current window (length n) is not
 *         in the first position, swap it with its left neighbor and return true.
 * Case 2: If the maximum is first, recursively advance the tail (length n-1).
 *         If the recursive call succeeds, rotate the window left by one
 *         (i.e., "append a1"); return true. If it fails, return false.
 *
 * Preconditions:
 *  - The input window a[start..start+len-1] is a permutation of {1..len}
 *    (no duplicates, values in that range). For the public entry, a is a
 *    permutation of {1..a.length}.
 *
 * Postconditions:
 *  - Returns true iff there exists a next permutation in this order; the
 *    array is modified in-place to that next permutation.
 *  - Returns false if this was already the last permutation; the array
 *    remains unchanged (still the last permutation).
 *
 * Ordering notes:
 *  - This is NOT lexicographic order. It generates permutations via adjacent
 *    transpositions according to the two cases above (the order shown in the
 *    handout).
 *
 * Complexity:
 *  - Time per call: O(n) in the size of the current window (to find n and
 *    possibly rotate). Generating all permutations costs O(n · n!).
 *  - Space: O(n) call stack in the worst case due to recursion depth.
 *
 * Edge cases:
 *  - n <= 1: no next permutation (returns false).
 *  - Arrays containing values outside {1..n} or duplicates violate the
 *    precondition and yield undefined behavior for this algorithm.
 *
 * Example:
 *  Input:  [1,2,3]
 *  Calls:  true → [1,3,2], true → [3,1,2], true → [2,1,3],
 *          true → [2,3,1], true → [3,2,1], false (no change)
 *
 * Testing ideas:
 *  - For n=1..5, iterate until false and assert you see exactly n! distinct
 *    permutations, each differing from the previous by the algorithm’s rule.
 *  - Property: contents are always a permutation of the original multiset.
 *  - Last call must return false and leave the array unchanged.
 */