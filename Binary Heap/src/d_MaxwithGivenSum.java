import java.util.*;

public class d_MaxwithGivenSum {

    /*
     * Goal:
     * Buy maximum number of items within given budget (sum).
     *
     * Optimal Greedy Idea:
     * Always buy the cheapest available item first.
     *
     * Optimized Implementation:
     * - Build a min-heap in O(n) using PriorityQueue(Collection)
     * - Then repeatedly buy cheapest while budget allows
     *
     * Time Complexity:
     *   Build heap: O(n)
     *   Each poll: O(log n) done 'ans' times
     *   Total: O(n + ans * log n)
     *
     * Space Complexity: O(n)
     */
    public static int maxItems(int[] cost, int sum) {

        // Convert int[] -> List<Integer> (needed for bulk heap constructor)
        List<Integer> items = new ArrayList<>(cost.length);
        for (int c : cost) items.add(c);

        // Build heap in O(n) (bulk heapify)
        PriorityQueue<Integer> pq = new PriorityQueue<>(items);

        int bought = 0;

        // Buy cheapest items until budget runs out
        while (!pq.isEmpty() && pq.peek() <= sum) {
            sum -= pq.poll();  // poll removes cheapest in O(log n)
            bought++;
        }

        return bought;
    }

    public static void main(String[] args) {
        int[] cost = {1, 12, 5, 111, 200};
        int sum = 10;

        System.out.println(maxItems(cost, sum)); // Output: 2 (buys 1 and 5)
    }
}