import java.util.*;

public class e_KLargestElems {

    /*
     * Returns the k largest elements using a min-heap of size k.
     *
     * Why min-heap?
     * - Heap stores only k elements (current k largest)
     * - The smallest among them is at the top (peek)
     * - If we find a bigger element, we replace that smallest
     *
     * Time: O(n log k)
     * Space: O(k)
     */
    public static List<Integer> kLargest(int[] arr, int k) {
        int n = arr.length;
        if (k <= 0) return new ArrayList<>();
        if (k > n) k = n;

        // Min-heap: smallest element is at top
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 1) Add first k elements into heap
        for (int i = 0; i < k; i++) {
            minHeap.offer(arr[i]);
        }

        // 2) For remaining elements, keep only k largest
        for (int i = k; i < n; i++) {
            int x = arr[i];

            // If x is not bigger than the smallest in heap, ignore it
            if (x <= minHeap.peek()) continue;

            // Else, replace the smallest with x
            minHeap.poll();
            minHeap.offer(x);
        }

        // Heap now has k largest (not necessarily sorted)
        return new ArrayList<>(minHeap);
    }

    // If you want output sorted in descending order (optional)
    public static List<Integer> kLargestSortedDesc(int[] arr, int k) {
        List<Integer> res = kLargest(arr, k);
        res.sort(Collections.reverseOrder());
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };
        int k = 3;

        List<Integer> ans = kLargestSortedDesc(arr, k);
        System.out.println(ans); // example output: [96, 88, 50]
    }
}