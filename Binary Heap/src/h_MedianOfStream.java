import java.util.*;

public class h_MedianOfStream {

    /*
     * Problem:
     * Given a stream of numbers, print the median
     * after each insertion.
     *
     * Approach:
     * Use TWO heaps:
     *
     * 1) Max Heap (s) -> stores smaller half
     * 2) Min Heap (g) -> stores larger half
     *
     * Invariant Rules:
     * - Size difference between heaps should not exceed 1
     * - All elements in maxHeap <= elements in minHeap
     *
     * Time Complexity:
     * Each insertion: O(log n)
     * Overall: O(n log n)
     */

    public static void printMedians(int[] arr, int n) {

        // Min Heap (stores larger half)
        PriorityQueue<Integer> g = new PriorityQueue<>();

        // Max Heap (stores smaller half)
        PriorityQueue<Integer> s =
                new PriorityQueue<>(Collections.reverseOrder());

        // Step 1: Insert first element into max heap
        s.add(arr[0]);
        System.out.print(arr[0] + " ");

        // Process remaining elements
        for (int i = 1; i < n; i++) {

            int x = arr[i];

            // CASE 1: Max heap has more elements
            if (s.size() > g.size()) {

                if (x < s.peek()) {
                    // Move largest of smaller half to min heap
                    g.add(s.poll());
                    s.add(x);
                } else {
                    g.add(x);
                }

                // Now both heaps have equal size
                double median =
                        ((double) s.peek() + g.peek()) / 2;

                System.out.print(median + " ");
            }

            // CASE 2: Both heaps have equal size
            else {

                if (x <= s.peek()) {
                    s.add(x);
                } else {
                    g.add(x);
                    s.add(g.poll());
                }

                // Now max heap has one extra element
                System.out.print(s.peek() + " ");
            }
        }
    }

    // Driver
    public static void main(String[] args) {

        int[] keys = {12, 15, 10, 5, 8, 7, 16};

        printMedians(keys, keys.length);
    }
}