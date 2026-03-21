import java.util.*;

/**
 * BFS Traversal for a DISCONNECTED undirected graph.
 *
 * Approach:
 * 1) Maintain visited[] array.
 * 2) Run BFS from every node that is still unvisited.
 *
 * This covers all connected components.
 */
public class c_BFSdisconnected {

    /**
     * Adds an undirected edge (u <-> v)
     * Time: O(1)
     */
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    /**
     * Standard BFS starting from source 's'
     *
     * Note: visited[] is passed from outside so that
     * the disconnected traversal (outer loop) can share it.
     *
     * Time: O(V_component + E_component)
     */
    static void BFS(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {

        // Queue is used because BFS is level-order traversal (FIFO)
        Queue<Integer> q = new LinkedList<>();

        // Mark source as visited and push it into queue
        visited[s] = true;
        q.add(s);

        // Process nodes until queue is empty
        while (!q.isEmpty()) {

            // Remove front node from queue
            int u = q.poll();
            System.out.print(u + " ");

            // Explore neighbors of node u
            for (int v : adj.get(u)) {

                // If neighbor not visited, visit it and push into queue
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }

    /**
     * BFS traversal for DISCONNECTED graph.
     *
     * Logic:
     * - visited[] initially false for all.
     * - for each node i:
     *     if i is not visited -> BFS(i)
     *
     * This guarantees every connected component is covered.
     *
     * Total Time: O(V + E)  (overall across all BFS calls)
     * Space: O(V)
     */
    static void BFSDin(ArrayList<ArrayList<Integer>> adj, int V) {

        // visited[i] = true means node i already processed in some BFS
        boolean[] visited = new boolean[V]; // default values are false in Java

        // Try BFS from every node (covers disconnected components)
        for (int i = 0; i < V; i++) {

            // If node i is still not visited, it means it's a new component
            if (!visited[i]) {
                BFS(adj, i, visited);
            }
        }
    }

    public static void main(String[] args) {

        int V = 7;

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        /*
         Graph has 2 components:
         Component 1: 0-1-2-3 (connected)
         Component 2: 4-5-6   (connected)
        */
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 1, 3);

        addEdge(adj, 4, 5);
        addEdge(adj, 5, 6);
        addEdge(adj, 4, 6);

        System.out.println("BFS Traversal for Disconnected Graph:");
        BFSDin(adj, V);
    }
}