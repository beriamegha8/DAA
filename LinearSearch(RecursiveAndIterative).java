public class LinearSearch {

    // Iterative linear search
    public static int linearSearchIterative(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Target not found
    }

    // Recursive linear search
    public static int linearSearchRecursive(int[] arr, int target, int index) {
        if (index >= arr.length) {
            return -1; // Target not found
        }
        if (arr[index] == target) {
            return index;
        }
        return linearSearchRecursive(arr, target, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int target = 7;

        System.out.println("Iterative Linear Search: " + linearSearchIterative(arr, target));
        System.out.println("Recursive Linear Search: " + linearSearchRecursive(arr, target, 0));
    }
}
