import java.util.*;

class PrimAlgorithm {
    static class Edge {
        int node, weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        List<List<Edge>> adjList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int source, int destination, int weight) {
            adjList.get(source).add(new Edge(destination, weight));
            adjList.get(destination).add(new Edge(source, weight)); // For undirected graph
        }

        public void primMST() {
            boolean[] inMST = new boolean[vertices];
            int[] key = new int[vertices];
            int[] parent = new int[vertices];

            Arrays.fill(key, Integer.MAX_VALUE);
            Arrays.fill(parent, -1);

            PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));

            key[0] = 0;
            pq.add(new Edge(0, 0));

            int mstCost = 0;

            while (!pq.isEmpty()) {
                Edge current = pq.poll();
                int u = current.node;

                if (inMST[u]) continue;

                inMST[u] = true;
                mstCost += current.weight;

                for (Edge neighbor : adjList.get(u)) {
                    int v = neighbor.node;
                    int weight = neighbor.weight;

                    if (!inMST[v] && weight < key[v]) {
                        key[v] = weight;
                        parent[v] = u;
                        pq.add(new Edge(v, weight));
                    }
                }
            }

            System.out.println("Edges in the MST:");
            for (int i = 1; i < vertices; i++) {
                System.out.println("Source: " + parent[i] + " - Destination: " + i + " - Weight: " + key[i]);
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

        graph.primMST();
    }
}
