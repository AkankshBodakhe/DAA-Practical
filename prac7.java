import java.util.*;

class Graph {
    private int V; // Number of vertices
    private List<List<Node>> adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Node node = new Node(destination, weight);
        adj.get(source).add(node); // Add edge to the adjacency list
    }

    public void dijkstra(int source) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(V, Comparator.comparingInt(node -> node.weight));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Initialize the source vertex
        dist[source] = 0;
        minHeap.add(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            int u = minHeap.poll().vertex;

            for (Node neighbor : adj.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                // Relaxation step
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    minHeap.add(new Node(v, dist[v]));
                }
            }
        }

        // Print the shortest distances
        System.out.println("Shortest distances from source vertex " + source + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + ": " + dist[i]);
        }
    }

    private static class Node {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}

public class prac7 {
    public static void main(String[] args) {
        int V = 6; // Number of vertices
        Graph graph = new Graph(V);

        // Add edges with weights
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 7);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 4, 2);
        graph.addEdge(3, 5, 1);
        graph.addEdge(4, 5, 5);

        int sourceVertex = 0; // Source vertex for Dijkstra's algorithm

        graph.dijkstra(sourceVertex);
    }
}
