import java.util.*;

public class m_ShrtPathDAG {

    /*
        FUNCTION: topoSort
        ---------------------------------------------------
        This function performs DFS and stores nodes in stack
        in such a way that when we pop from stack,
        we get Topological Order.

        Why push after DFS calls?
        -> Because in Topological Sort, a node should come
           after all its outgoing neighbors are processed.

        TC: O(N + M)
        SC: O(N + M)
    */
    public static void topoSort(int node, List<List<int[]>> adj,
                                boolean[] visited, Stack<Integer> stack) {

        // Mark current node as visited
        visited[node] = true;

        // Traverse all neighbors of current node
        for (int[] neighbor : adj.get(node)) {

            int nextNode = neighbor[0];
            int weight = neighbor[1]; // not used in topo sort, but part of adjacency format

            // If neighbor is not visited, do DFS on it
            if (!visited[nextNode]) {
                topoSort(nextNode, adj, visited, stack);
            }
        }

        /*
            Push current node after visiting all neighbors

            This is the important part:
            postorder DFS push gives topological order in reverse,
            so later popping from stack gives correct topo order.
        */
        stack.push(node);
    }

    /*
        FUNCTION: shortestPath
        ---------------------------------------------------
        Finds shortest path from source node 0
        in a Directed Acyclic Graph (DAG)

        WHY NOT DIJKSTRA HERE?
        -> Because DAG has no cycles
        -> We can solve more efficiently using:
           1. Topological Sort
           2. Relax edges in topo order

        Time Complexity becomes O(N + M)
    */
    public static int[] shortestPath(int N, int M, int[][] edges) {

        // STEP 1: Create adjacency list
        /*
            Each entry adj.get(u) stores:
            {v, wt}
            meaning edge u -> v with weight wt
        */
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // STEP 2: Fill adjacency list from edges array
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj.get(u).add(new int[]{v, wt});
        }

        // STEP 3: Topological Sort using DFS
        boolean[] visited = new boolean[N];
        Stack<Integer> stack = new Stack<>();

        // Run DFS from every unvisited node
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                topoSort(i, adj, visited, stack);
            }
        }

        // STEP 4: Create distance array
        int[] dist = new int[N];

        // Initially mark all nodes as unreachable
        Arrays.fill(dist, (int) 1e9);

        // Source node is 0, so distance to source = 0
        dist[0] = 0;

        /*
            STEP 5: Process nodes in Topological Order

            Why topo order?
            -> When we process a node, all possible shorter ways
               to reach it are already finalized.
            -> Then we relax its outgoing edges.
        */
        while (!stack.isEmpty()) {
            int node = stack.pop();

            // Only process if current node is reachable
            if (dist[node] != (int) 1e9) {

                // Traverse all outgoing edges from current node
                for (int[] neighbor : adj.get(node)) {
                    int v = neighbor[0];
                    int wt = neighbor[1];

                    /*
                        Relaxation step:
                        If going through 'node' gives a shorter path to 'v',
                        then update dist[v]
                    */
                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
        }

        // STEP 6: Convert unreachable nodes from infinity to -1
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    /*
        MAIN METHOD
        ---------------------------------------------------
        Driver code to test shortest path in DAG
    */
    public static void main(String[] args) {

        // Number of nodes and edges
        int N = 6, M = 7;

        // Directed weighted edges: {u, v, wt}
        int[][] edges = {
                {0, 1, 2},
                {0, 4, 1},
                {4, 5, 4},
                {4, 2, 2},
                {1, 2, 3},
                {2, 3, 6},
                {5, 3, 1}
        };

        // Call shortest path function
        int[] result = shortestPath(N, M, edges);

        // Print shortest distance from source 0 to all nodes
        System.out.println("Shortest distances from source 0:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}