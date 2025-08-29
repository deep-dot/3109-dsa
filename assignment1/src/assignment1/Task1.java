package assignment1;

import java.util.Arrays;

public class Task1 {

    // Public entry: advances to the next permutation (per the given spec).
    // Returns true if advanced, false if no further permutations exist.
    public static boolean nextPermutation(int[] a) {
        return nextPermutation(a, 0, a.length);
    }

    // Works on the window a[start .. start+len-1], which (by construction)
    // is a permutation of {1..len}.
    private static boolean nextPermutation(int[] a, int start, int len) {
        if (len <= 1) return false; // no more permutations for 0/1 element

        // Find the position 'pos' of the maximum element n (= len) in this window
        int n = len;
        int pos = -1;
        for (int k = 0; k < len; k++) {
            if (a[start + k] == n) { pos = start + k; break; }
        }

        if (pos != start) {
            // Case 1: n is NOT in the first position -> swap a_i with a_{i-1}
            swap(a, pos, pos - 1);
            return true;
        }

        // Case 2: n IS in the first position -> recurse on (a2..an)
        boolean advanced = nextPermutation(a, start + 1, len - 1);
        if (!advanced) return false; // no further permutations

        // After a successful recursive step, "append a1" to the result:
        // rotate the current window left by 1 (move first element to the end).
        rotateLeftByOne(a, start, len);
        return true;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    private static void rotateLeftByOne(int[] a, int start, int len) {
        int first = a[start];
        for (int i = start; i < start + len - 1; i++) {
            a[i] = a[i + 1];
        }
        a[start + len - 1] = first;
    }

    // Demo
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        do {
            System.out.println(Arrays.toString(a));
        } while (nextPermutation(a));
        // Prints in this order: [1,2,3], [1,3,2], [3,1,2], [2,1,3], [2,3,1], [3,2,1]
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
