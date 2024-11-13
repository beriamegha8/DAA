public class BinarySearch {

    // Iterative binary search
    public static int binarySearchIterative(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }

    // Recursive binary search
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // Target not found
        }

        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right);
        }
        return binarySearchRecursive(arr, target, left, mid - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int target = 7;

        System.out.println("Iterative Binary Search: " + binarySearchIterative(arr, target));
        System.out.println("Recursive Binary Search: " + binarySearchRecursive(arr, target, 0, arr.length - 1));
    }
}
