import java.util.*;

class j_Topsort {

    /*
        DFS for Topological Sort

        Logic:
        1. Mark current node as visited
        2. Visit all unvisited neighbours
        3. After visiting all neighbours, push current node into stack

        Why push at the end?
        Because a node should come before the nodes that depend on it.
        So we store it only after finishing its outgoing edges.
    */
    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> st) {

        // mark current node as visited
        vis[node] = 1;

        // visit all neighbours
        for (int neighbour : adj.get(node)) {
            if (vis[neighbour] == 0) {
                dfs(neighbour, adj, vis, st);
            }
        }

        // push after all neighbours are done
        st.push(node);
    }

    /*
        Function to perform Topological Sort

        Topological sort is valid only for Directed Acyclic Graph (DAG).
    */
    static ArrayList<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();

        // run DFS from every unvisited node
        // because graph can have multiple disconnected components
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, adj, vis, st);
            }
        }

        // stack gives answer in reverse finishing order
        ArrayList<Integer> ans = new ArrayList<>();
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }

        return ans;
    }

    public static void main(String[] args) {

        int V = 6;

        // create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // directed edges
        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        ArrayList<Integer> res = topoSort(V, adj);

        System.out.print("Topological Sort: ");
        for (int node : res) {
            System.out.print(node + " ");
        }
    }
}