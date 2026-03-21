import java.util.*;

class i_CycleDir {

    /*
        DFS function to detect cycle in a directed graph.

        vis[node] = 1
            -> node has been visited before

        pathVis[node] = 1
            -> node is currently in the recursion stack (current DFS path)

        If we encounter a node that is already in pathVis,
        it means we came back to a node in the same path → cycle.
    */
    static boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis) {

        // mark node as visited
        vis[node] = 1;

        // mark node as part of current DFS path
        pathVis[node] = 1;

        // explore all neighbours
        for (int neighbour : adj.get(node)) {

            // Case 1: neighbour not visited → continue DFS
            if (vis[neighbour] == 0) {
                if (dfsCheck(neighbour, adj, vis, pathVis)) {
                    return true; // cycle found deeper in recursion
                }
            }

            // Case 2: neighbour already in current DFS path → cycle
            else if (pathVis[neighbour] == 1) {
                return true;
            }
        }

        /*
            Backtracking step:
            remove node from the current recursion path
            because DFS is returning to the previous node
        */
        pathVis[node] = 0;

        return false;
    }


    /*
        Function to check if a directed graph has a cycle.

        V = number of vertices
        adj = adjacency list
    */
    static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] vis = new int[V];      // visited nodes
        int[] pathVis = new int[V];  // nodes in current DFS path

        // run DFS for every node (graph may have multiple components)
        for (int i = 0; i < V; i++) {

            if (vis[i] == 0) {
                if (dfsCheck(i, adj, vis, pathVis)) {
                    return true;
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {

        int V = 11;

        // create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // directed edges
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);

        // cycle component
        // 8 -> 9 -> 10 -> 8
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        boolean ans = isCyclic(V, adj);

        if (ans)
            System.out.println("True");
        else
            System.out.println("False");
    }
}