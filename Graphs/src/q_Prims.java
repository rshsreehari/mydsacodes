import java.util.*;

public class q_Prims {

    /*
        CLASS: Pair
        ---------------------------------------------------
        This class is used inside the Priority Queue.

        We store:
        distance -> edge weight
        node     -> node to which this edge leads

        Why "distance" name?
        In shortest path it usually means distance,
        but here in Prim's it actually means edge weight.

        So effectively Pair = {edgeWeight, node}
    */
    static class Pair {
        int node;
        int distance;

        public Pair(int distance, int node) {
            this.node = node;
            this.distance = distance;
        }
    }

    /*
        FUNCTION: spanningTree
        ---------------------------------------------------
        Returns the sum of weights of edges
        in the Minimum Spanning Tree (MST).

        WHAT IS MST?
        -> A tree connecting all vertices
        -> Uses exactly V-1 edges
        -> No cycles
        -> Total edge weight is minimum

        IMPORTANT:
        -> Prim's works on UNDIRECTED, CONNECTED, WEIGHTED graph
        -> If graph is disconnected, this code gives MST sum
           only for the connected component reachable from start node 0

        IDEA OF PRIM'S:
        -> Start from any node
        -> Always pick the minimum weight edge
           that connects a visited node to an unvisited node

        This is GREEDY.
    */
    public static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {

        /*
            STEP 1: Min Heap / Priority Queue

            Stores Pair(edgeWeight, node)

            Why Priority Queue?
            -> So that we always pick the smallest available edge first
        */
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        /*
            STEP 2: Visited array

            vis[i] = 1 means node i is already included in MST
            vis[i] = 0 means node i is not yet included
        */
        int[] vis = new int[V];

        /*
            STEP 3: Start from node 0 with edge weight 0

            Why weight 0?
            -> Starting node itself does not require any edge
            -> We just begin building MST from here
        */
        pq.add(new Pair(0, 0));

        // This will store the total weight of MST
        int sum = 0;

        /*
            STEP 4: Process nodes until PQ becomes empty
        */
        while (!pq.isEmpty()) {

            // Take the edge/node with minimum weight
            Pair curr = pq.poll();

            int wt = curr.distance; // edge weight used to reach this node
            int node = curr.node;   // current node

            /*
                If node is already part of MST, skip it

                Why?
                -> Same node may be inserted multiple times
                   from different edges
                -> We only take the first minimum one
            */
            if (vis[node] == 1) continue;

            /*
                Include this node in MST
            */
            vis[node] = 1;

            /*
                Add the chosen edge weight to MST sum

                For starting node, this adds 0
            */
            sum += wt;

            /*
                Traverse all adjacent nodes of current node
            */
            for (int i = 0; i < adj.get(node).size(); i++) {

                /*
                    In this adjacency format:
                    adj.get(node).get(i).get(0) = adjacent node
                    adj.get(node).get(i).get(1) = edge weight
                */
                int adjNode = adj.get(node).get(i).get(0);
                int edW = adj.get(node).get(i).get(1);

                /*
                    If adjacent node is not yet part of MST,
                    push it into PQ
                */
                if (vis[adjNode] == 0) {
                    pq.add(new Pair(edW, adjNode));
                }
            }
        }

        /*
            TIME COMPLEXITY:
            ----------------
            Priority Queue operations take log(V)
            For all edges, insertion/removal happens

            TC = O(E log E)   or commonly written as O(E log V)

            WHY?
            -> Every edge can go into PQ
            -> PQ operation is logarithmic

            SPACE COMPLEXITY:
            -----------------
            vis array = O(V)
            PQ can store up to O(E) entries in worst case

            SC = O(V + E)
        */
        return sum;
    }

    /*
        MAIN METHOD
        ---------------------------------------------------
        Driver code to test Prim's Algorithm
    */
    public static void main(String[] args) {

        int V = 5;

        /*
            Graph edges: {u, v, w}

            Undirected weighted graph
        */
        int[][] edges = {
                {0, 1, 2},
                {0, 2, 1},
                {1, 2, 1},
                {2, 3, 2},
                {3, 4, 1},
                {4, 2, 2}
        };

        /*
            Adjacency list format used here:
            adj.get(u) contains list of [v, w]
        */
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build undirected graph
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> temp1 = new ArrayList<>();
            temp1.add(v);
            temp1.add(w);

            ArrayList<Integer> temp2 = new ArrayList<>();
            temp2.add(u);
            temp2.add(w);

            adj.get(u).add(temp1);
            adj.get(v).add(temp2);
        }

        int sum = spanningTree(V, adj);

        System.out.println("The sum of all the edge weights in MST: " + sum);
    }
}