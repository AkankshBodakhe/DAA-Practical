import java.util.*;
class Edge implements Comparable<Edge> {
    int src, dest, weight;
    public int compareTo(Edge otherEdge) {
        return this.weight - otherEdge.weight;
    }
};
class prac4 {
    int V, E;
    Edge[] edges;
    prac4(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; ++i) {
            edges[i] = new Edge();
        }
    }
    int find(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }
    void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }
    void kruskalMST() {
        Edge[] result = new Edge[V - 1];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        Arrays.sort(edges);
        int e = 0;
        int i = 0;
        while (e < V - 1 && i < E) {
            Edge nextEdge = edges[i++];
            int x = find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);
            if (x != y) {
                result[e++] = nextEdge;
                union(parent, x, y);
            }
        }
        System.out.println("Edges in Minimum Spanning Tree:");
        int minimumCost = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " - " + result[i].dest + " : " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost: " + minimumCost);
    }
    public static void main(String[] args) {
        int V = 9;
        int E = 14;
        prac4 graph = new prac4(V, E);

        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = 4;

        graph.edges[1].src = 0;
        graph.edges[1].dest = 7;
        graph.edges[1].weight = 8;

        graph.edges[2].src = 1;
        graph.edges[2].dest = 7;
        graph.edges[2].weight = 11;

        graph.edges[3].src = 1;
        graph.edges[3].dest = 2;
        graph.edges[3].weight = 8;

        graph.edges[4].src = 7;
        graph.edges[4].dest = 8;
        graph.edges[4].weight = 7;

        graph.edges[5].src = 7;
        graph.edges[5].dest = 6;
        graph.edges[5].weight = 1;

        graph.edges[6].src = 6;
        graph.edges[6].dest = 8;
        graph.edges[6].weight = 6;

        graph.edges[7].src = 6;
        graph.edges[7].dest = 5;
        graph.edges[7].weight = 2;

        graph.edges[8].src = 8;
        graph.edges[8].dest = 2;
        graph.edges[8].weight = 2;

        graph.edges[9].src = 2;
        graph.edges[9].dest = 3;
        graph.edges[9].weight = 7;

        graph.edges[10].src = 2;
        graph.edges[10].dest = 5;
        graph.edges[10].weight = 4;

        graph.edges[11].src = 3;
        graph.edges[11].dest = 5;
        graph.edges[11].weight = 14;

        graph.edges[12].src = 3;
        graph.edges[12].dest = 4;
        graph.edges[12].weight = 9;

        graph.edges[13].src = 4;
        graph.edges[13].dest = 5;
        graph.edges[13].weight = 10;

        graph.kruskalMST();
    }
}
