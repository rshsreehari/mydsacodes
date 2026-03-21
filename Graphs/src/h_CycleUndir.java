import java.util.*;

public class h_CycleUndir {

    /*
     * Adds an undirected edge between u and v.
     * Since the graph is undirected:
     *   u -> v
     *   v -> u
     */
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    /*
     * Recursive DFS function to detect cycle.
     *
     * adj     -> adjacency list
     * s       -> current vertex being explored
     * visited -> keeps track of visited vertices
     * parent  -> the vertex from which 's' was reached
     *
     * Why parent is needed?
     * In an undirected graph, every edge appears twice.
     * So when we go from u -> v,
     * v will naturally see u as already visited.
     * That should NOT be considered a cycle.
     *
     * A cycle exists only if:
     * - We find an already visited vertex
     * - AND that vertex is NOT the parent
     */
    static boolean DFSRec(ArrayList<ArrayList<Integer>> adj,
                          int s,
                          boolean[] visited,
                          int parent) {

        // Mark current node as visited
        visited[s] = true;

        // Traverse all adjacent vertices
        for (int u : adj.get(s)) {

            // Case 1: If adjacent node is not visited,
            // continue DFS deeper
            if (!visited[u]) {
                if (DFSRec(adj, u, visited, s))
                    return true;  // Cycle found in deeper call
            }

            // Case 2: If adjacent node is visited
            // and is NOT parent → cycle detected
            else if (u != parent) {
                return true;
            }
        }

        // No cycle found from this path
        return false;
    }

    /*
     * Handles disconnected graph.
     * We must check DFS from every unvisited node,
     * because the graph may have multiple components.
     */
    static boolean DFS(ArrayList<ArrayList<Integer>> adj, int V) {

        boolean[] visited = new boolean[V];

        // Initialize visited array
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // Check each component
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (DFSRec(adj, i, visited, -1))
                    return true;  // Cycle found
            }
        }

        return false;  // No cycle in any component
    }

    public static void main(String[] args) {

        int V = 6;

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Add edges
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);  // This edge creates a cycle

        // Check for cycle
        if (DFS(adj, V))
            System.out.println("Cycle found");
        else
            System.out.println("No cycle found");
    }
}