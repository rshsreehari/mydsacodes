import java.util.*;

public class s_Kruskals {

    /*
        CLASS: Edge
        ---------------------------------------------------
        Represents one edge in the graph

        u = source node
        v = destination node
        wt = weight of edge

        We store all edges in a list,
        then sort them by weight for Kruskal's Algorithm
    */
    static class Edge {
        int u, v, wt;

        public Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    /*
        FUNCTION: kruskalMST
        ---------------------------------------------------
        Returns the total weight of the Minimum Spanning Tree

        PARAMETERS:
        n     -> number of vertices
        edges -> list of all edges in graph

        KRUSKAL'S IDEA:
        1. Sort all edges by weight
        2. Pick the smallest edge
        3. Add it only if it does NOT form a cycle
        4. Use Disjoint Set to check cycle efficiently

        WHY DISJOINT SET?
        -> If u and v already belong to same component,
           adding edge (u,v) creates cycle
        -> So skip it

        OTHERWISE:
        -> Safe to include this edge in MST
        -> Union both components

        RETURN:
        -> total MST weight
    */
    public static int kruskalMST(int n, List<Edge> edges) {

        /*
            STEP 1:
            Sort edges in increasing order of weight

            Smallest edge should be processed first
        */
        Collections.sort(edges, (a, b) -> a.wt - b.wt);

        /*
            STEP 2:
            Create Disjoint Set for n nodes

            We are using your existing class:
            r_DisjointSet.DisjointSet
        */
        r_DisjointSet.DisjointSet ds = new r_DisjointSet.DisjointSet(n);

        int mstWeight = 0;

        /*
            Optional:
            To show which edges are included in MST
        */
        List<Edge> mstEdges = new ArrayList<>();

        /*
            STEP 3:
            Traverse edges one by one
        */
        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            int wt = edge.wt;

            /*
                Check whether u and v are already in same component

                If same:
                -> adding this edge forms cycle
                -> skip it

                If different:
                -> safe to include in MST
            */
            if (ds.findUPar(u) != ds.findUPar(v)) {
                ds.unionBySize(u, v);   // you can also use unionByRank(u, v)
                mstWeight += wt;
                mstEdges.add(edge);
            }
        }

        /*
            Print MST edges for understanding
        */
        System.out.println("Edges in MST:");
        for (Edge e : mstEdges) {
            System.out.println(e.u + " - " + e.v + " : " + e.wt);
        }

        return mstWeight;
    }

    /*
        MAIN METHOD
        ---------------------------------------------------
        Example graph

        Graph:
            1 --2-- 2
            |      / |
            6    3   8
            |  /     |
            3 --7-- 4
             \      /
               9
                5

        We'll provide edges manually
    */
    public static void main(String[] args) {

        int n = 5; // number of vertices

        List<Edge> edges = new ArrayList<>();

        /*
            Add all edges: (u, v, weight)

            For undirected graph,
            add each edge only once
        */
        edges.add(new Edge(1, 2, 2));
        edges.add(new Edge(1, 4, 6));
        edges.add(new Edge(2, 3, 3));
        edges.add(new Edge(2, 4, 8));
        edges.add(new Edge(2, 5, 5));
        edges.add(new Edge(3, 5, 7));
        edges.add(new Edge(4, 5, 9));

        int ans = kruskalMST(n, edges);

        System.out.println("Total MST Weight: " + ans);
    }
}