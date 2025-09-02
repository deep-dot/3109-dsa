
package assignment1;

import java.util.Arrays;

public class Task2 {

	// ---- counters ----
	public static long qsComps, msComps, isComps;

	// ---- insertion sort (counts comparisons) ----
	public static long insertionSort(int[] a) {
		isComps = 0;
		for (int i = 1; i < a.length; i++) {
			int t = a[i];
			for (int j = i - 1; j >= 0 && t < a[j]; j--) {
				a[j + 1] = a[j];
				a[j] = t;
				isComps++;
			}
		}
		
		return isComps;
	}

	// mergesort
	public static long mergeSort(int[] a) {
		msComps = 0;
		return msort(a, 0, a.length - 1);
	}

	private static long msort(int[] a, int first, int last) {
		if (first >= last) return 0;	// no comparisons
		int mid = (int) Math.floor((first + last) / 2);
		long cmps = 0;
		cmps += msort(a, first, mid); // comparisons from left half
		cmps += msort(a, mid + 1, last); // comparisons from right half
		cmps += merge(a, first, mid, last); // comparisons while merging
		return cmps;
	}

	private static long merge(int[] a, int first, int mid, int last) {
		int[] temp = new int[last + 1];
		int first1 = first;
		int last1 = mid;
		int first2 = mid + 1;
		int last2 = last;
		int index = first1;

		while (first1 <= last1 && first2 <= last2) {
			msComps++;
			if (a[first1] < a[first2]) {
				temp[index++] = a[first1++];
			} else {
				temp[index++] = a[first2++];
			}
		}
		while (first1 <= last1) {
			temp[index++] = a[first1++];
		}
		while (first2 <= last2) {
			temp[index++] = a[first2++];
		}
		for (index = first; index <= last; index++)
			a[index] = temp[index];
		
		return msComps;
	}

//	When merge(a, first, mid, last) runs, both halves a[first..mid] and a[mid+1..last] are already sorted in-place by the two earlier msort calls. merge then uses indices to read those actual values:
//
//		first1 is a cursor in the left half → current value is a[first1]
//
//		first2 is a cursor in the right half → current value is a[first2]
//
//		index is where we’re writing in temp
//
//		Because Java arrays are reference types, every call works on the same array object. So when msort(a, first, mid) returns, it has already rearranged the numbers in a[first..mid]. merge “knows” the values simply by reading a[i] at those indices.
//
//		Tiny trace to make it concrete
//
//		Start: a = [5, 2, 4, 6]
//
//		msort(a, 0, 1) sorts the left half in place → a becomes [2, 5, 4, 6]
//
//		msort(a, 2, 3) sorts the right half (already [4,6]) → a stays [2, 5, 4, 6]
//
//		merge(a, 0, 1, 3) now sees:
//
//		left half = a[0..1] = [2,5]
//
//		right half = a[2..3] = [4,6]
//
//		Inside merge:
//
//		Set i=0 (left), j=2 (right), k=0 (temp write)
//
//		Compare values a[i]=2 and a[j]=4 → take 2 → temp[0]=2, i=1, k=1
//
//		Compare a[i]=5 and a[j]=4 → take 4 → temp[1]=4, j=3, k=2
//
//		Compare a[i]=5 and a[j]=6 → take 5 → temp[2]=5, i=2, k=3
//
//		Left side finished; copy leftover right (6) → temp[3]=6
//
//		Copy temp[0..3] back to a[0..3] → a = [2,4,5,6]

	// quicksort
	public static long quickSort(int[] a) {
		qsComps = 0;
		qsort(a, 0, a.length - 1);
		return qsComps;
	}

	private static void qsort(int[] a, int left, int right) {
		if (left >= right) return;
		
		int p = partition(a, left, right);
		qsort(a, left, p - 1);
		qsort(a, p + 1, right);
	}

	private static int partition(int[] a, int left, int right) {
		while (true) {
			while (left < right && a[left] < a[right]) {
				right--;
				qsComps++;
			}
			
			if (left < right) {
				swap(a, left++, right);
			}
			else
				return left;
			
			while (left < right && a[left] < a[right]) {
				left++;
				qsComps++;
			}
			if (left < right)
				swap(a, left, right--);
			else
				return right;
		}
	}

	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	// ---- tiny self-checks on size 3–4 arrays ----
	public static void main(String[] args) {
		int[][] tests = { { 3, 2, 1 }, { 2, 1, 3 }, { 3, 1, 2, 0 }, { 1, 1, 2 }, };

		for (int[] src : tests) {
			System.out.println("\nArray: " + Arrays.toString(src));

			int [] a1 = src.clone();
			insertionSort(a1);
			System.out.println("Insertion : " + Arrays.toString(a1) + " | comps=" + isComps);

			int[] a2 = src.clone();
			mergeSort(a2);
			System.out.println("Merge     : " + Arrays.toString(a2) + " | comps=" + msComps);

			int[] a3 = src.clone();
			quickSort(a3);
			System.out.println("Quick     : " + Arrays.toString(a3) + " | comps=" + qsComps);
		}
	}
}
