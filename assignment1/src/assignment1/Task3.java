package assignment1;

import java.util.Scanner;

public class Task3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter the array size: ");
		int n = sc.nextInt();
		sc.close();

		if (n < 1) {
			System.out.println("Array size must be >= 1");
		}

		int[] a = new int[n];
		long totalPerm = 0, qscmps = 0, mscmps = 0, iscmps = 0;

		for (int i = 0; i < n; i++) {
			a[i] = i + 1;
		}

		do {
			
			int [] a1 = a.clone();
			
			iscmps += Task2.insertionSort(a1);

			int[] a2 = a.clone();
			mscmps += Task2.mergeSort(a2);

			int[] a3 = a.clone();
			qscmps += Task2.quickSort(a3);

			totalPerm++;

		} while (Task1_1.nextPermutationRec(a, 0, a.length));

		double aveIns = (double) iscmps / totalPerm;
		double aveMer = (double) mscmps / totalPerm;
		double aveQs = (double) qscmps / totalPerm;

		System.out.println("\nResults: ");
		System.out.println("Array size is: " + n + " and total permutations you processed: " + totalPerm);

		System.out.printf("Insertion Sort comparisons: %d  Average comparisons: %.2f%n", iscmps, aveIns);
		System.out.printf("Merge Sort comparisons:     %d  Average comparisons: %.2f%n", mscmps, aveMer);
		System.out.printf("Quick Sort comparisons:     %d  Average comparisons: %.2f%n", qscmps, aveQs);
	}

}
