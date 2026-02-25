import java.util.*;

public class f_Kclosestele {

    /*
     * Problem:
     * Find k elements closest to x in an array.
     *
     * Approach:
     * Use a MAX heap of size k.
     * Heap stores (element, difference from x).
     *
     * Why MAX heap?
     * Because we want to remove the element
     * having largest difference when we find a closer one.
     *
     * Time Complexity: O(n log k)
     * Space Complexity: O(k)
     */

    // Custom Pair class to store value and its difference
    static class Pair {
        int value;
        int diff;

        Pair(int value, int diff) {
            this.value = value;
            this.diff = diff;
        }
    }

    public static List<Integer> kClosest(int[] arr, int k, int x) {

        int n = arr.length;

        // Max heap based on difference
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> b.diff - a.diff
        );

        // Step 1: Insert first k elements
        for (int i = 0; i < k; i++) {
            int diff = Math.abs(arr[i] - x);
            pq.offer(new Pair(arr[i], diff));
        }

        // Step 2: Process remaining elements
        for (int i = k; i < n; i++) {

            int diff = Math.abs(arr[i] - x);

            // If current element is closer than farthest in heap
            if (diff < pq.peek().diff) {
                pq.poll();  // remove farthest
                pq.offer(new Pair(arr[i], diff));
            }
        }

        // Extract result
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().value);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {10, 30, 5, 40, 38, 80, 70};
        int x = 35;
        int k = 3;

        List<Integer> ans = kClosest(arr, k, x);
        System.out.println(ans);
    }
}