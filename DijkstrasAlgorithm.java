import java.util.*;

class Graph {
    private final int vertices;
    private final List<List<Node>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new Node(v, weight));
        adjList.get(v).add(new Node(u, weight)); // If the graph is undirected
    }

    public void dijkstra(int startNode) {
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startNode] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(node -> node.cost));
        pq.add(new Node(startNode, 0));
        
        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int u = currentNode.node;
            
            // Explore neighbors of u
            for (Node neighbor : adjList.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.cost;

                // If a shorter path to v is found
                if (distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    pq.add(new Node(v, distances[v]));
                }
            }
        }
        
        // Print the shortest path from the start node to all other nodes
        System.out.println("Shortest paths from node " + startNode + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To node " + i + " the shortest path cost is " + distances[i]);
        }
    }

    static class Node {
        int node;
        int cost;

        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        int vertices = 5; // Number of vertices in the graph
        Graph graph = new Graph(vertices);

        // Adding edges to the graph
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 1, 4);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 2);
        graph.addEdge(3, 4, 7);
        graph.addEdge(4, 3, 9);

        // Find shortest paths from node 0
        graph.dijkstra(0);
    }
}
