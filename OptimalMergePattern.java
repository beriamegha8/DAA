import java.util.*;

public class OptimalMergePattern {

    // Method to implement the Optimal Merge Pattern
    public static int optimalMerge(int[] fileSizes) {
        // Create a priority queue (min-heap) to store the file sizes
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all file sizes to the priority queue
        for (int size : fileSizes) {
            minHeap.add(size);
        }

        // Variable to store the total cost of merging
        int totalCost = 0;

        // While more than one file is left to merge
        while (minHeap.size() > 1) {
            // Extract the two smallest files
            int file1 = minHeap.poll();
            int file2 = minHeap.poll();

            // Calculate the cost of merging these two files
            int mergeCost = file1 + file2;
            totalCost += mergeCost;

            // Add the merged file back into the priority queue
            minHeap.add(mergeCost);
        }

        // Return the total cost of merging all files
        return totalCost;
    }

    public static void main(String[] args) {
        // Example file sizes
        int[] fileSizes = {10, 20, 30, 40, 50};

        // Calculate the minimum cost to merge the files
        int result = optimalMerge(fileSizes);

        // Print the result
        System.out.println("Minimum cost to merge all files: " + result);
    }
}
