
package assignment1;

import java.util.Arrays;

public class Task2 {

	public static long qsComps, msComps, isComps;

	// insertion sort
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

	public static void main(String[] args) {
		int[][] tests = {{ 3, 2, 1 }, { 2, 1, 3 }, { 3, 1, 2, 0 }, { 1, 1, 2 }};

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
