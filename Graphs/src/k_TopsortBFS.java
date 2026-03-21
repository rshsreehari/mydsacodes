import java.util.*;

/*
    Topological Sort using BFS (Kahn's Algorithm)

    Topological ordering of a graph means:
    For every directed edge u -> v,
    vertex u must appear before v in the ordering.

    This works only for Directed Acyclic Graphs (DAG).

    Idea:
    1. Calculate the indegree of every node.
       (indegree = number of incoming edges)

    2. Put all nodes with indegree = 0 into a queue.
       These nodes have no dependency.

    3. While queue is not empty:
        - Remove node from queue
        - Add it to the result (topological order)
        - Reduce indegree of its neighbours
        - If neighbour indegree becomes 0 → push to queue

    Time Complexity  : O(V + E)
    Space Complexity : O(V)
*/

public class k_TopsortBFS {

    // Function that performs Topological Sort
    public static int[] topologicalSort(int V, ArrayList<ArrayList<Integer>> adj) {

        // Step 1: Create array to store indegree of each node
        int[] indegree = new int[V];

        // Calculate indegree for every vertex
        for (int i = 0; i < V; i++) {
            for (int neighbour : adj.get(i)) {
                indegree[neighbour]++;
            }
        }

        // Step 2: Queue to process nodes with indegree = 0
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Array to store the final topological order
        int[] topo = new int[V];
        int index = 0;

        // Step 3: BFS traversal
        while (!queue.isEmpty()) {

            int node = queue.poll();

            // Add node to topological order
            topo[index++] = node;

            // Reduce indegree of all neighbours
            for (int neighbour : adj.get(node)) {

                indegree[neighbour]--;

                // If indegree becomes 0 → ready to process
                if (indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return topo;
    }


    public static void main(String[] args) {

        int V = 6;

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Directed edges
        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        int[] result = topologicalSort(V, adj);

        System.out.println("Topological Order:");

        for (int node : result) {
            System.out.print(node + " ");
        }
    }
}