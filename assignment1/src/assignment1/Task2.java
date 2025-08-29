
package assignment1;

import java.util.Arrays;

public class Task2 {

    // ---- counters ----
    public static long qsComps, msComps, isComps;

    // ---- insertion sort (counts comparisons) ----
    public static void insertionSort(int[] a) {
        isComps = 0;
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            // Compare while moving larger elements to the right
            while (j >= 0 && lessIS(key, a[j])) { // key < a[j]
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }
    private static boolean lessIS(int x, int y) {
        isComps++;                  // one element-to-element comparison
        return x < y;
    }

    // ---- mergesort (counts comparisons only when merging) ----
    public static void mergeSort(int[] a) {
        msComps = 0;
        int[] tmp = new int[a.length];
        msort(a, 0, a.length - 1, tmp);
    }
    private static void msort(int[] a, int l, int r, int[] tmp) {
        if (l >= r) return;
        int m = (l + r) >>> 1;
        msort(a, l, m, tmp);
        msort(a, m + 1, r, tmp);
        merge(a, l, m, r, tmp);
    }
    private static void merge(int[] a, int l, int m, int r, int[] tmp) {
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) {
            if (lessMS(a[i], a[j])) tmp[k++] = a[i++];
            else                     tmp[k++] = a[j++];
        }
        while (i <= m) tmp[k++] = a[i++];
        while (j <= r) tmp[k++] = a[j++];
        for (int t = l; t <= r; t++) a[t] = tmp[t];
    }
    private static boolean lessMS(int x, int y) {
        msComps++;                  // compare left[i] vs right[j]
        return x <= y;              // stable; ties from left
    }

    // ---- quicksort (Lomuto partition; counts comparisons in partition) ----
    public static void quickSort(int[] a) {
        qsComps = 0;
        qsort(a, 0, a.length - 1);
    }
    private static void qsort(int[] a, int l, int r) {
        if (l >= r) return;
        int p = partition(a, l, r); // pivot = a[r]
        qsort(a, l, p - 1);
        qsort(a, p + 1, r);
    }
    private static int partition(int[] a, int l, int r) {
        int pivot = a[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (lessQS(a[j], pivot)) { // compare a[j] <= pivot
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }
    private static boolean lessQS(int x, int pivot) {
        qsComps++;                  // one element-to-pivot comparison
        return x <= pivot;
    }

    // ---- helpers ----
    private static void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    // ---- tiny self-checks on size 3–4 arrays ----
    public static void main(String[] args) {
        int[][] tests = {
            {3,2,1},
            {2,1,3},
            {3,1,2,0},
            {1,1,2},          // duplicates to see mergesort stability & quicksort count behavior
        };

        for (int[] src : tests) {
            System.out.println("\nArray: " + Arrays.toString(src));

            int[] a1 = Arrays.copyOf(src, src.length);
            insertionSort(a1);
            System.out.println("Insertion : " + Arrays.toString(a1) + " | comps=" + isComps);

            int[] a2 = Arrays.copyOf(src, src.length);
            mergeSort(a2);
            System.out.println("Merge     : " + Arrays.toString(a2) + " | comps=" + msComps);

            int[] a3 = Arrays.copyOf(src, src.length);
            quickSort(a3);
            System.out.println("Quick     : " + Arrays.toString(a3) + " | comps=" + qsComps);
        }
    }
}
