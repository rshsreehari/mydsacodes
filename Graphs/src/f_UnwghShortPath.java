import java.util.*;

public class f_UnwghShortPath {

    /*
     * Adds an undirected edge between u and v
     * Since graph is undirected:
     *   u -> v
     *   v -> u
     */
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    /*
     * Performs BFS traversal to compute shortest distance
     * from source 's' to all other vertices.
     *
     * adj  -> adjacency list representation of graph
     * V    -> number of vertices
     * s    -> source vertex
     * dist -> distance array (stores shortest distance from s)
     */
    static void BFS(ArrayList<ArrayList<Integer>> adj, int V, int s, int[] dist) {

        // visited array to avoid revisiting nodes
        boolean[] visited = new boolean[V];

        // Initialize visited array
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // Queue for BFS (FIFO structure)
        Queue<Integer> q = new LinkedList<>();

        // Start from source node
        visited[s] = true;
        q.add(s);

        /*
         * BFS traversal:
         * Remove from queue
         * Explore all adjacent nodes
         * Update their distance
         */
        while (!q.isEmpty()) {

            int u = q.poll();   // Remove front element

            // Traverse all adjacent vertices of u
            for (int v : adj.get(u)) {

                // If not visited yet
                if (!visited[v]) {

                    // Distance update rule:
                    // distance of neighbour = distance of parent + 1
                    dist[v] = dist[u] + 1;

                    visited[v] = true;  // Mark visited
                    q.add(v);           // Push into queue
                }
            }
        }
    }

    public static void main(String[] args) {

        int V = 4;  // Number of vertices

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Add edges
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);

        // Distance array
        int[] dist = new int[V];

        // Initialize distances to infinity
        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        // Distance of source from itself = 0
        dist[0] = 0;

        // Call BFS from source 0
        BFS(adj, V, 0, dist);

        // Print shortest distances
        System.out.println("Shortest distances from source 0:");
        for (int i = 0; i < V; i++)
            System.out.print(dist[i] + " ");
    }
}