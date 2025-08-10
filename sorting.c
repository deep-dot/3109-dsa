
// bubble sort

// #include <stdio.h>
// #include <stdlib.h>

// int main() {
//    int arr[]= {3,4,1,9,5,6,10}, i, j, temp;

//    for(i=0;i<sizeof(arr)/sizeof(arr[0]); i++){
//     for(j=i+1; j<sizeof(arr)/sizeof(arr[0]); j++) {
//         if(arr[i] < arr[j]) {
//             temp = arr[i];
//             arr[i] = arr[j];
//             arr[j] = temp;
//         }
//     }
//      printf("%d ", arr[i]);
//    }
//    printf("largest number is %d ", arr[0]);
//    printf("\n");

//    return 0;
// }

// selection sort

// #include <stdio.h>
// #include <stdlib.h>

// int largest(int *, int, int *);
// void swap(int *, int, int);

// int main()
// {
//     int arr[] = {3, 4, 1, 9, 5, 6, 10}, ln, index;
//     int n = sizeof(arr) / sizeof(arr[0]);
//     for (int i = n - 1; i >= 0; i--)
//     {
//         index = largest(arr, i, &ln);
//         swap(arr, index, i);
//     }
//     printf("Sorted array: ");
//     for (int i = 0; i < n; i++)
//     {
//         printf("%d ", arr[i]);
//     }
//     printf("\n");
//     printf("largest number is %d index is %d\n", arr[n-1], n-1);
//     return 0;
// }

// int largest(int *arr, int end, int *ln)
// {
//     int index = 0;
//     *ln = arr[index];
//     for (int i = 1; i <= end; i++)
//     {
//         if (*ln < arr[i])
//         {
//             *ln = arr[i];
//             index = i;
//         }
//     }
//     return index;
// }

// void swap(int *a, int index, int last_index)
// {
//     int temp = a[index];
//     a[index] = a[last_index];
//     a[last_index] = temp;
// }

// insertion sort
// #include <stdio.h>
// #include <stdlib.h>

// int main(void){
//     int arr[] = {3, 4, 1, 9, 5, 6, 10}, ln, index, temp, j;
//     int n = sizeof(arr) / sizeof(arr[0]);

//     for(int i = 1; i < n; i++) {
//         temp = arr[i];
//         j = i - 1;
//         while (j >= 0 && arr[j] > temp) {
//             arr[j+1] = arr[j];
//             j--;
//         }
//         arr[j+1] = temp;
//     }
//     printf("Sorted array: ");
//     for(int i = 0; i < n; i++) {
//         printf("%d ", arr[i]);
//     }
//     printf("\n");
//     return 0;
// }

// merge sort
// #include <stdio.h>
// #include <stdlib.h>

// void simpleSort(int *arr, int left, int right) {
//     for(int i = 1; i<= right; i++) {
//         int key = arr[i];
//         int j = i-1;
//         while( j>=0 && arr[j] > key) {
//             arr[j+1] = arr[j];
//             j--;
//         }
//         arr[j+1] = key;
//     }
// }
// int main(void){
//     int arr[] = {3, 4, 1, 9, 5, 6, 10}, ln, index, temp;
//     int n = sizeof(arr) / sizeof(arr[0]);
//     int mid, left1, right1, left2, right2, temp_arr[n];
//     mid = n / 2;
//     left1 = 0;
//     right1 = mid;
//     left2 = mid + 1;
//     right2 = n - 1;
//     int i = left1, j = left2, k = 0;

//     simpleSort(arr, left1, right1);
//     simpleSort(arr, left2, right2);
//     while (i <= right1 && j <= right2) {
//         if(arr[i] < arr[j]) {
//             temp_arr[k++] = arr[i++];
//         } else {
//             temp_arr[k++] = arr[j++];
//         }
//     }

//     while (i <= right1) {
//         temp_arr[k++] = arr[i++];
//     }
//     while (j <= right2) {
//         temp_arr[k++] = arr[j++];
//         left2++;
//     }
//     for(int i = 0; i < n; i++) {
//         arr[i] = temp_arr[i];
//     }

//     printf("Sorted array: ");
//     for(int i = 0; i < n; i++) {
//         printf("%d ", arr[i]);
//     }
//     printf("\n");
//     return 0;
// }

// quick sort

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

void swap(int *arr, int i, int j)
{
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}


// Key points:

// Use a single infinite loop (while(1)).
// Move i right until you find an element ≥ pivot.
// Move j left until you find an element ≤ pivot.
// If i >= j, return j.
// Otherwise, swap v[i] and v[j].

int partition(int *v, int left, int right) {
    int pivot = v[left];
    int i = left - 1;
    int j = right + 1;
    while (1) {
        do {
            i++;
        } while (v[i] < pivot);

        do {
            j--;
        } while (v[j] > pivot);

        if (i >= j)
            return j;

        swap(v, i, j);
    }
}

void quickSort(int *arr, int low, int high)
{
    if (low < high)
    {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}
int main()
{
    int arr[] = {3, 4, 1, 9, 5, 6, 10};
    int n = sizeof(arr) / sizeof(arr[0]);
    quickSort(arr, 0, n - 1);
    printf("Sorted array: ");
    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");
    return 0;
}