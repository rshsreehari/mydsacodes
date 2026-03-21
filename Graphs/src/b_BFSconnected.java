import java.util.*;

/**
 * Breadth First Search (BFS)
 *
 * Used for:
 * - Shortest path in unweighted graph
 * - Level order traversal
 * - Connected components
 * - Cycle detection
 *
 * Core Idea:
 * Explore neighbors level by level using a Queue (FIFO).
 */
public class b_BFSconnected {

    /**
     * Add an undirected edge between u and v
     * Time Complexity: O(1)
     */
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    /**
     * BFS Traversal from source node s
     *
     * @param adj - Adjacency List
     * @param V   - Number of vertices
     * @param s   - Starting node (source)
     *
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     */
    static void BFS(ArrayList<ArrayList<Integer>> adj, int V, int s) {

        // Step 1: Visited array to avoid revisiting nodes
        boolean[] visited = new boolean[V];

        // Step 2: Create Queue for BFS (FIFO structure)
        Queue<Integer> q = new LinkedList<>();

        // Step 3: Mark source as visited and push into queue
        visited[s] = true;
        q.add(s);

        // Step 4: Run BFS until queue becomes empty
        while (!q.isEmpty()) {

            // Remove front element
            int u = q.poll();
            System.out.print(u + " ");

            // Visit all unvisited neighbors of u
            for (int v : adj.get(u)) {

                if (!visited[v]) {
                    visited[v] = true;  // mark visited
                    q.add(v);           // push into queue
                }
            }
        }
    }

    public static void main(String[] args) {

        int V = 5;

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 2, 4);

        System.out.println("BFS Traversal starting from node 0:");
        BFS(adj, V, 0);
    }
}