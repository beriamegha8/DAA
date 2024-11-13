public class MergeSortPasswise {

    // Method to perform merge sort and display array after each merge
    public static void mergeSort(int[] arr, int left, int right, int pass) {
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;

            // Recursively sort the first and second halves
            mergeSort(arr, left, mid, pass + 1); // Left half
            mergeSort(arr, mid + 1, right, pass + 1); // Right half

            // Merge the sorted halves
            merge(arr, left, mid, right);

            // Display the array after the merge
            System.out.print("Pass " + pass + ": ");
            displayArray(arr);
        }
    }

    // Merge two sorted halves of the array
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, mid + 1, rightArray, 0, n2);

        // Merge the temp arrays back into the original array
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from leftArray[] if any
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements from rightArray[] if any
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Utility method to display the array
    private static void displayArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        System.out.println("Initial Array:");
        displayArray(arr);

        // Start merge sort and display each pass
        mergeSort(arr, 0, arr.length - 1, 1);

        System.out.println("Sorted Array:");
        displayArray(arr);
    }
}
