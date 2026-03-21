import java.util.*;

public class p_FloydWarshall {

    /*
        FUNCTION: shortest_distance
        ---------------------------------------------------
        Finds shortest distance between EVERY PAIR of vertices.

        This is an ALL-PAIRS SHORTEST PATH algorithm.

        INPUT:
        matrix[i][j] = direct distance from i to j

        Here:
        -1 means NO DIRECT PATH exists
         0 means same node
        positive value means direct edge weight

        IMPORTANT:
        -> Works for directed graphs
        -> Can handle negative edges
        -> Cannot give valid answer if negative cycle exists
        -> Can be used to detect negative cycle

        MAIN IDEA:
        Try every node 'k' as an intermediate node
        between every pair (i, j)

        Formula:
        dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
    */
    public static void shortest_distance(int[][] matrix) {

        // Number of vertices
        int n = matrix.length;

        /*
            STEP 1: Use every node k as an intermediate node

            Meaning:
            Can shortest path from i to j become smaller
            if we go through node k?
        */
        for (int k = 0; k < n; k++) {

            /*
                STEP 2: Check all possible source nodes i
            */
            for (int i = 0; i < n; i++) {

                /*
                    STEP 3: Check all possible destination nodes j
                */
                for (int j = 0; j < n; j++) {

                    /*
                        If i -> k path does not exist
                        OR
                        if k -> j path does not exist
                        then path i -> k -> j cannot be formed
                    */
                    if (matrix[i][k] == -1 || matrix[k][j] == -1) {
                        continue;
                    }

                    /*
                        CASE 1:
                        No direct path currently from i to j

                        Then if path through k exists,
                        directly assign that new path
                    */
                    if (matrix[i][j] == -1) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }

                    /*
                        CASE 2:
                        Direct path already exists

                        Compare:
                        current path i -> j
                        vs
                        new path i -> k -> j

                        Take minimum
                    */
                    else {
                        matrix[i][j] = Math.min(matrix[i][j],
                                matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }

        /*
            OPTIONAL NEGATIVE CYCLE CHECK:
            --------------------------------
            After Floyd Warshall,
            if matrix[i][i] < 0 for any i,
            then negative cycle exists.

            Why?
            Because distance from node to itself
            should never become negative unless
            a negative cycle is present.

            Example check:
            for (int i = 0; i < n; i++) {
                if (matrix[i][i] < 0) {
                    System.out.println("Negative cycle exists");
                }
            }
        */

        /*
            TIME COMPLEXITY:
            ----------------
            3 nested loops over n
            => O(N^3)

            SPACE COMPLEXITY:
            -----------------
            In-place update of matrix
            => O(1) extra space
            (ignoring input matrix storage)
        */
    }

    /*
        MAIN METHOD
        ---------------------------------------------------
        Driver code to test Floyd Warshall
    */
    public static void main(String[] args) {

        int[][] matrix = {
                {0, 2, -1, -1},
                {1, 0, 3, -1},
                {-1, -1, 0, -1},
                {3, 5, 4, 0}
        };

        // Call Floyd Warshall
        shortest_distance(matrix);

        // Print shortest distance matrix
        int n = matrix.length;
        System.out.println("The shortest distance matrix is:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}