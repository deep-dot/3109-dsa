
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
#include <stdio.h>
#include <stdlib.h>

int main(void){
    int arr[] = {3, 4, 1, 9, 5, 6, 10}, ln, index, temp, j;
    int n = sizeof(arr) / sizeof(arr[0]);

    for(int i = 1; i < n; i++) {
        temp = arr[i];
        j = i - 1;
        while (j >= 0 && arr[j] > temp) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = temp;
    }
    printf("Sorted array: ");
    for(int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
    return 0;
}