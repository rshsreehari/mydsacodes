import java.util.*;

/**
 * Class to represent an Undirected Graph
 * using Adjacency List representation.
 *
 * Important for Google SDE:
 * - Graph representation is fundamental.
 * - Adjacency List is preferred over Matrix for sparse graphs.
 */
public class a_AdjacencyList {

    // Number of vertices in the graph
    private int V;

    // Adjacency List
    // adj.get(i) contains list of neighbors of vertex i
    private ArrayList<ArrayList<Integer>> adj;

    /**
     * Constructor to initialize graph with V vertices
     *
     * Time Complexity: O(V)
     * Space Complexity: O(V)
     */
    public a_AdjacencyList(int V) {
        this.V = V;

        // Initialize adjacency list
        adj = new ArrayList<>();

        // Create empty list for each vertex
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    /**
     * Adds an undirected edge between u and v
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * NOTE:
     * For Directed Graph:
     * remove -> adj.get(v).add(u);
     */
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    /**
     * Prints the adjacency list of the graph
     *
     * Time Complexity: O(V + E)
     */
    public void printGraph() {

        for (int i = 0; i < V; i++) {

            System.out.print("Vertex " + i + " -> ");

            for (int neighbor : adj.get(i)) {
                System.out.print(neighbor + " ");
            }

            System.out.println();
        }
    }

    /**
     * Getter (useful in BFS/DFS problems)
     */
    public ArrayList<ArrayList<Integer>> getAdjList() {
        return adj;
    }

    /**
     * Driver Code
     */
    public static void main(String[] args) {

        // Number of vertices
        int V = 4;

        // Create graph
        a_AdjacencyList graph = new a_AdjacencyList(V);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        // Print graph
        graph.printGraph();
    }
}