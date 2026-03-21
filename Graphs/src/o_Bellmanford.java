import java.util.*;

public class o_Bellmanford {

    /*
        FUNCTION: bellman_ford
        ---------------------------------------------------
        Finds shortest distance from source S to all nodes.

        IMPORTANT FEATURES:
        ✔ Works with NEGATIVE weights
        ✔ Detects NEGATIVE CYCLE
        ✔ Slower than Dijkstra

        INPUT:
        V -> number of vertices
        edges -> list of edges [u, v, wt]
        S -> source node

        TC = O(V * E)
        SC = O(V + E)
    */
    public static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {

        /*
            STEP 1: Distance Array

            Initialize all distances as infinity (unreachable)
            Using large number instead of Integer.MAX_VALUE to avoid overflow
        */
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);

        // Distance to source is 0
        dist[S] = 0;

        /*
            STEP 2: RELAX EDGES V-1 TIMES

            WHY V-1 TIMES?
            -> In worst case, shortest path can have at most V-1 edges
            -> After V-1 relaxations, all shortest paths are finalized

            TIME COMPLEXITY HERE:
            -> O(V * E)
        */
        for (int i = 0; i < V - 1; i++) {

            // Traverse all edges
            for (ArrayList<Integer> edge : edges) {

                int u = edge.get(0); // from node
                int v = edge.get(1); // to node
                int wt = edge.get(2); // weight

                /*
                    RELAXATION STEP:

                    Only relax if:
                    1. u is reachable
                    2. new path is shorter
                */
                if (dist[u] != (int)1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        /*
            STEP 3: NEGATIVE CYCLE DETECTION

            If we can still relax after V-1 iterations,
            -> NEGATIVE CYCLE exists

            WHY?
            -> Because shortest path should already be finalized
            -> Further improvement means infinite reduction
        */
        for (ArrayList<Integer> edge : edges) {

            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);

            if (dist[u] != (int)1e8 && dist[u] + wt < dist[v]) {

                /*
                    If negative cycle detected:
                    return [-1]
                */
                return new int[]{-1};
            }
        }

        // No negative cycle → return distances
        return dist;
    }

    /*
        MAIN METHOD (Driver Code)
    */
    public static void main(String[] args) {

        int V = 6;
        int S = 0;

        /*
            Edge list: {u, v, wt}
            Directed graph
        */
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        edges.add(new ArrayList<>(Arrays.asList(3, 2, 6)));
        edges.add(new ArrayList<>(Arrays.asList(5, 3, 1)));
        edges.add(new ArrayList<>(Arrays.asList(0, 1, 5)));
        edges.add(new ArrayList<>(Arrays.asList(1, 5, -3)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2, -2)));
        edges.add(new ArrayList<>(Arrays.asList(3, 4, -2)));
        edges.add(new ArrayList<>(Arrays.asList(2, 4, 3)));

        int[] dist = bellman_ford(V, edges, S);

        System.out.println("Shortest distances from source " + S + ":");

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }
}