import java.util.*;

public class r_DisjointSet {

    /*
        CLASS: DisjointSet
        ---------------------------------------------------
        Also called:
        -> Union Find
        -> DSU (Disjoint Set Union)

        PURPOSE:
        -> Keep track of connected components
        -> Efficiently answer:
            "Are u and v in same set?"
            "Merge two sets"

        CORE OPERATIONS:
        1. findUPar(node)  -> find ultimate parent (leader)
        2. unionByRank(u,v)
        3. unionBySize(u,v)
    */
    static class DisjointSet {

        /*
            rank:
            -> Approximate height of tree
            -> Used in unionByRank

            parent:
            -> parent[i] = parent of node i
            -> If parent[i] == i → i is root

            size:
            -> size of component
            -> Used in unionBySize
        */
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        /*
            CONSTRUCTOR
            ---------------------------------------------------
            Initially:
            -> Each node is its own parent
            -> Each node is its own component
        */
        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);     // initial rank = 0
                parent.add(i);   // parent of itself
                size.add(1);     // size = 1
            }
        }

        /*
            FUNCTION: findUPar (Find Ultimate Parent)
            ---------------------------------------------------

            Returns the root/leader of the set

            IMPORTANT OPTIMIZATION:
            -> PATH COMPRESSION

            Idea:
            When finding parent, flatten the tree
            so future queries are faster

            Example:
            1 -> 2 -> 3 -> 4

            After find(1):
            1 -> 4
            2 -> 4
            3 -> 4

            TC:
            -> Almost O(1)
            -> Amortized: O(α(N)) (inverse Ackermann, very small)

            This is why DSU is super fast
        */
        public int findUPar(int node) {

            // If node is its own parent → root
            if (node == parent.get(node)) {
                return node;
            }

            // Recursively find root
            int ulp = findUPar(parent.get(node));

            // Path compression step
            parent.set(node, ulp);

            return parent.get(node);
        }

        /*
            FUNCTION: unionByRank
            ---------------------------------------------------

            Merge two sets using RANK (tree height)

            Idea:
            -> Attach smaller tree under larger tree
            -> Keeps tree shallow

            Steps:
            1. Find ultimate parents
            2. If same → already connected
            3. Attach smaller rank tree under larger
            4. If equal → increase rank

            TC:
            -> O(α(N)) per operation (almost constant)
        */
        public void unionByRank(int u, int v) {

            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);

            // Already in same set
            if (ulp_u == ulp_v) return;

            // Attach smaller rank under bigger rank
            if (rank.get(ulp_u) < rank.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
            }
            else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u);
            }
            else {
                // Same rank → attach and increase rank
                parent.set(ulp_v, ulp_u);
                rank.set(ulp_u, rank.get(ulp_u) + 1);
            }
        }

        /*
            FUNCTION: unionBySize
            ---------------------------------------------------

            Merge two sets using SIZE

            Idea:
            -> Attach smaller component under larger component

            Why better sometimes?
            -> More accurate than rank
            -> Directly considers number of nodes

            Steps:
            1. Find ultimate parents
            2. Attach smaller size under larger
            3. Update size

            TC:
            -> O(α(N)) per operation
        */
        public void unionBySize(int u, int v) {

            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);

            // Already same component
            if (ulp_u == ulp_v) return;

            // Attach smaller size under larger size
            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            }
            else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }

    /*
        MAIN METHOD
        ---------------------------------------------------
        Demonstrates DSU operations
    */
    public static void main(String[] args) {

        DisjointSet ds = new DisjointSet(7);

        /*
            Initially:
            All nodes are separate components

            {1}, {2}, {3}, {4}, {5}, {6}, {7}
        */

        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);

        /*
            Now:
            {1,2,3}
        */

        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);

        /*
            Now:
            {4,5}, {6,7}
        */

        ds.unionByRank(5, 6);

        /*
            Now:
            {4,5,6,7}
        */

        // Check if 3 and 7 are connected
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }

        // Connect both components
        ds.unionByRank(3, 7);

        // Check again
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }

        /*
            OUTPUT:
            Not Same
            Same
        */
    }
}