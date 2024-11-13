import java.util.Scanner;

public class QuickSortWithPivotChoice {

    // Main Quick Sort method that accepts a pivot choice
    public static void quickSort(int[] arr, int low, int high, int pass, int pivotChoice) {
        if (low < high) {
            // Partition the array around pivot and get the pivot index
            int pivotIndex = partition(arr, low, high, pivotChoice);

            // Display the array after each pass
            System.out.print("Pass " + pass + ": ");
            displayArray(arr);
            pass++;

            // Recursively sort elements before and after partition
            quickSort(arr, low, pivotIndex - 1, pass, pivotChoice);
            quickSort(arr, pivotIndex + 1, high, pass, pivotChoice);
        }
    }

    // Partition method that selects a pivot based on user's choice
    private static int partition(int[] arr, int low, int high, int pivotChoice) {
        int pivot = selectPivot(arr, low, high, pivotChoice); // Select pivot based on choice
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap elements at i and j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place the pivot element at the correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return the pivot index
    }

    // Method to choose the pivot element based on user's choice
    private static int selectPivot(int[] arr, int low, int high, int pivotChoice) {
        switch (pivotChoice) {
            case 1: // First element as pivot
                int tempFirst = arr[low];
                arr[low] = arr[high];
                arr[high] = tempFirst;
                break;
            case 2: // Last element as pivot
                // No change needed, already chosen
                break;
            case 3: // Middle element as pivot
                int mid = low + (high - low) / 2;
                int tempMid = arr[mid];
                arr[mid] = arr[high];
                arr[high] = tempMid;
                break;
            default:
                System.out.println("Invalid pivot choice.");
        }
        return arr[high]; // Return the pivot (now at arr[high])
    }

    // Utility method to display the array
    private static void displayArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = { 10, 7, 8, 9, 1, 5 };
        System.out.println("Initial Array:");
        displayArray(arr);

        // Prompt the user for pivot choice
        System.out.println("Choose Pivot Strategy:");
        System.out.println("1. First Element");
        System.out.println("2. Last Element");
        System.out.println("3. Middle Element");
        int pivotChoice = scanner.nextInt();

        // Start quick sort with the chosen pivot strategy and display each pass
        quickSort(arr, 0, arr.length - 1, 1, pivotChoice);

        System.out.println("Sorted Array:");
        displayArray(arr);
        
        scanner.close();
    }
}
