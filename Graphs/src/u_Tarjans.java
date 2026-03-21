import java.util.*;

public class u_Tarjans {

    // Tarjans Algorithm for finding critical edge
    /*
    but its actually built to get the strongly connected components (SCC) given a graph
     */
    /*
        timer:
        ---------------------------------------------------
        Gives each node a discovery time in DFS order.

        Example:
        first visited node  -> tin = 1
        second visited node -> tin = 2
        ...
    */
    private int timer = 1;

    /*
        FUNCTION: dfs
        ---------------------------------------------------
        Performs DFS and finds bridges using Tarjan's idea.

        PARAMETERS:
        node    -> current node
        parent  -> from where we came to current node
        vis     -> visited array
        adj     -> adjacency list
        tin     -> time of insertion / discovery time
        low     -> lowest reachable discovery time
        bridges -> answer list
    */
    private void dfs(int node, int parent, boolean[] vis,
                     List<List<Integer>> adj, int[] tin, int[] low,
                     List<List<Integer>> bridges) {

        // Mark current node visited
        vis[node] = true;

        // Set both tin and low initially to current timer
        tin[node] = low[node] = timer++;

        /*
            Explore all neighbours
        */
        for (int neighbor : adj.get(node)) {

            /*
                If neighbor is parent, skip it
                because in undirected graph parent edge appears again
            */
            if (neighbor == parent) continue;

            /*
                CASE 1:
                Neighbor not visited yet
                -> Tree edge
            */
            if (!vis[neighbor]) {

                // DFS on child
                dfs(neighbor, node, vis, adj, tin, low, bridges);

                /*
                    After coming back from child,
                    update low[node] using child's low

                    Why?
                    Because child subtree may reach an earlier ancestor
                */
                low[node] = Math.min(low[node], low[neighbor]);

                /*
                    Bridge condition:
                    if child cannot reach node or any ancestor of node,
                    then edge (node, neighbor) is a bridge

                    low[neighbor] > tin[node]
                */
                if (low[neighbor] > tin[node]) {
                    bridges.add(Arrays.asList(node, neighbor));
                }
            }

            /*
                CASE 2:
                Neighbor already visited and not parent
                -> Back edge

                So current node can reach an earlier visited ancestor
                through this back edge
            */
            else {
                low[node] = Math.min(low[node], tin[neighbor]);
            }
        }
    }

    /*
        FUNCTION: criticalConnections
        ---------------------------------------------------
        Returns all bridges in graph
    */
    public List<List<Integer>> criticalConnections(int n, int[][] connections) {

        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Helper arrays
        boolean[] vis = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];

        List<List<Integer>> bridges = new ArrayList<>();

        /*
            Run DFS for all components
            Important:
            Graph may be disconnected
        */
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, -1, vis, adj, tin, low, bridges);
            }
        }

        return bridges;
    }

    /*
        MAIN METHOD
        ---------------------------------------------------
        Example graph:
            0 - 1
            |  / \
            2     3

        edges:
        0-1, 1-2, 2-0 form a cycle
        1-3 is a bridge
    */
    public static void main(String[] args) {
        int n = 4;
        int[][] connections = {
                {0, 1},
                {1, 2},
                {2, 0},
                {1, 3}
        };

        u_Tarjans obj = new u_Tarjans();
        List<List<Integer>> bridges = obj.criticalConnections(n, connections);

        System.out.println("Critical Connections (Bridges): " + bridges);
    }
}