package assignment1;

import java.util.Arrays;

public class Task1_1 {

//    a recursive function 
//    named nextPermutation that generates the next permutation 
//    of a given sequence of integers. 
	public static boolean nextPermutationRec(int[] a, int start, int len) {
		if (len <= 1)
			return false; // no permutations for 0 and 1 element
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
		boolean result = nextPermutationRec(a, start + 1, len - 1);
		if (!result)
			return false; // no further permutations

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
		int[] a = { 1, 2, 3 };
		do {
			System.out.println(Arrays.toString(a));
		} while (nextPermutationRec(a, 0, a.length));
	}
}

