import java.util.*;

public class n_Dijkstras {

    /*
        FUNCTION: dijkstra
        ---------------------------------------------------
        Finds shortest distance from source node S
        to all other nodes in a weighted graph.

        IMPORTANT:
        -> Works only when all weights are NON-NEGATIVE
        -> Uses Greedy + Priority Queue

        IDEA:
        Always process the node with the smallest known distance first.

        TC: O((V + E) log V)
        SC: O(V + E)
    */
    public static int[] dijkstra(int V, ArrayList<int[]>[] adj, int S) {

        /*
            STEP 1: Priority Queue (Min Heap)

            Stores:
            {distance, node}

            Why?
            -> Always process closest node first
        */
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        /*
            STEP 2: Distance array

            Initially:
            -> All nodes unreachable → INF
        */
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Distance to source is 0
        dist[S] = 0;

        // Push source into PQ
        pq.offer(new int[]{0, S});

        /*
            STEP 3: Process nodes using PQ
        */
        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int dis = curr[0];   // current distance
            int node = curr[1];  // current node

            /*
                IMPORTANT OPTIMIZATION (optional but good):

                If current distance > stored distance,
                skip processing (outdated entry)

                Uncomment if needed:
                if (dis > dist[node]) continue;
            */

            // Traverse all neighbors of current node
            for (int[] edge : adj[node]) {

                int adjNode = edge[0]; // neighbor
                int weight = edge[1];  // edge weight

                /*
                    RELAXATION STEP:

                    If going through 'node' gives shorter path to adjNode
                */
                if (dis + weight < dist[adjNode]) {

                    dist[adjNode] = dis + weight;

                    // Push updated distance into PQ
                    pq.offer(new int[]{dist[adjNode], adjNode});
                }
            }
        }

        return dist;
    }

    /*
        MAIN METHOD
        ---------------------------------------------------
        Driver code to test Dijkstra
    */
    public static void main(String[] args) {

        int V = 3, E = 3, S = 2;

        // Adjacency list
        ArrayList<int[]>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        /*
            Graph:
            0 --1--> 1
            0 --6--> 2
            1 --3--> 2
            (Undirected edges added manually)
        */

        adj[0].add(new int[]{1, 1});
        adj[0].add(new int[]{2, 6});

        adj[1].add(new int[]{2, 3});
        adj[1].add(new int[]{0, 1});

        adj[2].add(new int[]{1, 3});
        adj[2].add(new int[]{0, 6});

        // Call function
        int[] res = dijkstra(V, adj, S);

        // Print result
        System.out.println("Shortest distances from source " + S + ":");
        for (int i = 0; i < V; i++) {
            System.out.print(res[i] + " ");
        }
    }
}