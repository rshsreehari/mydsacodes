import java.util.*;

/**
 * Number of Islands (Graph Version)
 *
 * Concept:
 * Number of islands = Number of connected components
 * in an undirected graph.
 *
 * We:
 * 1) Run BFS from every unvisited node
 * 2) Each BFS call covers one connected component
 * 3) Count how many times BFS is called
 */
public class d_NoOfIslands {

    // Add undirected edge
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // Standard BFS
    static void BFS(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();

        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {

            int u = q.poll();

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }

    /**
     * Counts number of disconnected components
     * (Each component = 1 island)
     */
    static int countIslands(ArrayList<ArrayList<Integer>> adj, int V) {

        boolean[] visited = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++) {

            // If node not visited, it's a new component
            if (!visited[i]) {
                BFS(adj, i, visited);
                count++;   // One BFS = One island
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int V = 7;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Component 1
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 1, 3);

        // Component 2
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 6);
        addEdge(adj, 4, 6);

        System.out.println("Number of islands: " + countIslands(adj, V));
    }
}