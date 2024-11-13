import java.util.Arrays;

public class FloydWarshall {
    final static int INF = 99999; // Large value representing infinity

    public static void floydWarshall(int[][] graph) {
        int vertices = graph.length;
        int[][] dist = new int[vertices][vertices];

        // Initialize dist[][] with values from the graph
        for (int i = 0; i < vertices; i++) {
            System.arraycopy(graph[i], 0, dist[i], 0, vertices);
        }

        // Update dist[][] based on shortest paths using each vertex as an intermediate
        for (int k = 0; k < vertices; k++) { // Intermediate vertex
            for (int i = 0; i < vertices; i++) { // Start vertex
                for (int j = 0; j < vertices; j++) { // End vertex
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Display the shortest distances
        printSolution(dist);
    }

    public static void printSolution(int[][] dist) {
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 3, INF, 5},
            {2, 0, INF, 4},
            {INF, 1, 0, INF},
            {INF, INF, 2, 0}
        };

        floydWarshall(graph);
    }
}
