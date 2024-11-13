import java.util.*;

class KruskalAlgorithm {
    static class Edge implements Comparable<Edge> {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    static class Graph {
        int vertices;
        List<Edge> edges = new ArrayList<>();

        public Graph(int vertices) {
            this.vertices = vertices;
        }

        public void addEdge(int source, int destination, int weight) {
            edges.add(new Edge(source, destination, weight));
        }

        public int findParent(int vertex, int[] parent) {
            if (parent[vertex] != vertex) {
                parent[vertex] = findParent(parent[vertex], parent);
            }
            return parent[vertex];
        }

        public void union(int x, int y, int[] parent, int[] rank) {
            int rootX = findParent(x, parent);
            int rootY = findParent(y, parent);

            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }

        public void kruskalMST() {
            Collections.sort(edges);

            int[] parent = new int[vertices];
            int[] rank = new int[vertices];
            for (int i = 0; i < vertices; i++) {
                parent[i] = i;
                rank[i] = 0;
            }

            List<Edge> mst = new ArrayList<>();
            int mstCost = 0;

            for (Edge edge : edges) {
                int rootSource = findParent(edge.source, parent);
                int rootDestination = findParent(edge.destination, parent);

                if (rootSource != rootDestination) {
                    mst.add(edge);
                    mstCost += edge.weight;
                    union(rootSource, rootDestination, parent, rank);
                }
            }

            System.out.println("Edges in the MST:");
            for (Edge edge : mst) {
                System.out.println("Source: " + edge.source + " - Destination: " + edge.destination + " - Weight: " + edge.weight);
            }
            System.out.println("Total cost of MST: " + mstCost);
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 10);
        graph.addEdge(3, 4, 2);
        graph.addEdge(3, 5, 6);
        graph.addEdge(4, 5, 3);

        graph.kruskalMST();
    }
}
