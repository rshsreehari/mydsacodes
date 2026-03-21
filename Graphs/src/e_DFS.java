import java.util.*;

/**
 * Depth First Search (DFS)
 *
 * Core Idea:
 * Explore as deep as possible before backtracking.
 *
 * Uses:
 * - Recursion (implicit stack)
 * OR
 * - Explicit Stack (iterative version)
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)  (visited array + recursion stack)
 */
public class e_DFS {

    //disconnected and islands works the same as bfs
    //not writing code again
    /**
     * Add undirected edge between u and v
     * Time: O(1)
     */
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    /**
     * Recursive DFS function
     *
     * @param adj      Adjacency List
     * @param s        Current node
     * @param visited  Tracks visited nodes
     *
     * Steps:
     * 1) Mark current node visited
     * 2) Process it (print here)
     * 3) Recur for all unvisited neighbors
     */
    static void DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {

        // Step 1: Mark node visited
        visited[s] = true;

        // Step 2: Process node
        System.out.print(s + " ");

        // Step 3: Visit all unvisited neighbors
        //we only do this for one node neighbours and all will be covered
        //because that what dfs here means
        for (int u : adj.get(s)) {

            if (!visited[u]) {
                DFSRec(adj, u, visited);   // Go deeper
            }
        }
    }

    /**
     * DFS Wrapper Function
     *
     * Initializes visited array
     * Starts DFS from source node s
     */
    static void DFS(ArrayList<ArrayList<Integer>> adj, int V, int s) {

        boolean[] visited = new boolean[V];   // default false in Java

        DFSRec(adj, s, visited);
    }

    public static void main(String[] args) {

        int V = 7;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 3, 4);

        System.out.println("Following is Depth First Traversal:");

        DFS(adj, V, 0);
    }
}