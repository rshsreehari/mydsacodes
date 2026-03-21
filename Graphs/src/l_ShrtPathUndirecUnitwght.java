import java.util.*;

public class l_ShrtPathUndirecUnitwght {

    /*
        Function: shortestPath
        ----------------------------------------
        Finds shortest distance from source node to all other nodes
        in an UNDIRECTED graph with UNIT WEIGHTS using BFS.

        Why BFS?
        -> Because each edge has weight = 1
        -> BFS naturally gives shortest path in such graphs

        TC: O(N + M)
        SC: O(N + M)
    */
    public static int[] shortestPath(int[][] edges, int N, int M, int src) {

        // STEP 1: Create adjacency list
        // adj.get(i) will store all neighbors of node i
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize empty lists for all N nodes
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // STEP 2: Fill adjacency list (UNDIRECTED GRAPH)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v); // u -> v
            adj.get(v).add(u); // v -> u (because undirected)
        }

        // STEP 3: Distance array
        // Initially set all distances to "infinity"
        int[] dist = new int[N];
        Arrays.fill(dist, (int) 1e9);

        // Distance to source is always 0
        dist[src] = 0;

        // STEP 4: BFS Queue
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        /*
            STEP 5: BFS Traversal

            Key Idea:
            If we reach a node with a shorter distance,
            update it and push it into queue.
        */
        while (!q.isEmpty()) {

            int node = q.poll(); // current node

            // Traverse all neighbors
            for (int neighbor : adj.get(node)) {

                /*
                    Relaxation step:
                    If going via 'node' gives shorter path to 'neighbor'
                */
                if (dist[node] + 1 < dist[neighbor]) {

                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor); // push updated node
                }
            }
        }

        // STEP 6: Replace unreachable nodes (infinity) with -1
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    /*
        MAIN METHOD (Driver Code)
    */
    public static void main(String[] args) {

        int N = 9, M = 10;

        int[][] edges = {
                {0, 1}, {0, 3}, {3, 4}, {4, 5}, {5, 6},
                {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}
        };

        int src = 0;

        int[] result = shortestPath(edges, N, M, src);

        System.out.println("Shortest distances from source " + src + ":");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}