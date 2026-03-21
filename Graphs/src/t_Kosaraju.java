import java.util.*;

public class t_Kosaraju {

    /*
        FUNCTION 1: dfs
        ---------------------------------------------------
        Purpose:
        Perform normal DFS on original graph and push nodes
        into stack in the order of finishing time.

        Important:
        Node is pushed only AFTER all its neighbours are done.

        This finishing order is the key idea of Kosaraju.
    */
    private void dfs(int node, int[] vis, List<Integer>[] adj, Stack<Integer> st) {
        vis[node] = 1;

        // Visit all neighbours
        for (int next : adj[node]) {
            if (vis[next] == 0) {
                dfs(next, vis, adj, st);
            }
        }

        // Push after exploring everything from this node
        st.push(node);
    }

    /*
        FUNCTION 2: dfsOnTranspose
        ---------------------------------------------------
        Purpose:
        Perform DFS on the transposed graph.

        In Step 3 of Kosaraju, each DFS call on transpose graph
        gives one strongly connected component.
    */
    private void dfsOnTranspose(int node, int[] vis, List<Integer>[] adjT) {
        vis[node] = 1;

        for (int next : adjT[node]) {
            if (vis[next] == 0) {
                dfsOnTranspose(next, vis, adjT);
            }
        }
    }

    /*
        FUNCTION: kosaraju
        ---------------------------------------------------
        Returns the number of strongly connected components (SCCs)

        Steps:
        1. DFS on original graph and store nodes in stack by finish time
        2. Reverse all edges to create transpose graph
        3. Pop nodes from stack and do DFS on transpose graph
           Each DFS in this step = one SCC
    */
    public int kosaraju(int V, List<Integer>[] adj) {

        /*
            vis array:
            vis[i] = 1 means node i has been visited
        */
        int[] vis = new int[V];

        /*
            Stack to store nodes by finishing time
        */
        Stack<Integer> st = new Stack<>();

        // -------------------------------------------------
        // STEP 1: Fill stack using DFS on original graph
        // -------------------------------------------------
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }

        // -------------------------------------------------
        // STEP 2: Build transpose graph
        // -------------------------------------------------
        List<Integer>[] adjT = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjT[i] = new ArrayList<>();
        }

        /*
            Reset visited array for second DFS phase
        */
        Arrays.fill(vis, 0);

        /*
            Reverse every edge
            Original: i -> next
            Transpose: next -> i
        */
        for (int i = 0; i < V; i++) {
            for (int next : adj[i]) {
                adjT[next].add(i);
            }
        }

        // -------------------------------------------------
        // STEP 3: Process nodes in stack order on transpose
        // -------------------------------------------------
        int sccCount = 0;

        while (!st.isEmpty()) {
            int node = st.pop();

            /*
                If not visited in transpose DFS,
                then this starts a new SCC
            */
            if (vis[node] == 0) {
                sccCount++;
                dfsOnTranspose(node, vis, adjT);
            }
        }

        return sccCount;
    }

    /*
        MAIN METHOD
        ---------------------------------------------------
        Example graph:

            1 -> 0
            0 -> 2
            2 -> 1
            0 -> 3
            3 -> 4

        SCCs are:
        {0,1,2}, {3}, {4}

        So answer = 3
    */
    public static void main(String[] args) {
        int V = 5;

        int[][] edges = {
                {1, 0},
                {0, 2},
                {2, 1},
                {0, 3},
                {3, 4}
        };

        // Create adjacency list
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        // Add edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
        }

        t_Kosaraju obj = new t_Kosaraju();
        int ans = obj.kosaraju(V, adj);

        System.out.println("The number of strongly connected components is: " + ans);
    }
}