import java.util.*;

/*
 * Merge K Sorted Arrays (K-way merge) using a Min Heap.
 *
 * Input: k sorted arrays/lists
 * Output: one fully sorted list containing all elements
 *
 * Core idea:
 *  - Put the first element of each array into a min-heap.
 *  - Repeatedly extract the smallest element and push the next element
 *    from that same array.
 *
 * Time Complexity:
 *  - Let total elements = N, number of arrays = K
 *  - Each element is inserted + removed once from heap
 *  - Heap operations are O(log K)
 *  => Total: O(N log K)
 *
 * Space Complexity:
 *  - Heap stores at most K items
 *  => O(K) extra space
 */
public class g_MergeKSortedArrays {

    /*
     * Triplet stores:
     *  - val  : current value
     *  - aPos : which array/list this value came from
     *  - vPos : index inside that array/list
     *
     * Comparable ensures PriorityQueue becomes a MIN heap by val.
     */
    static class Triplet implements Comparable<Triplet> {
        int val;   // value
        int aPos;  // array position (which list)
        int vPos;  // value position (index inside that list)

        Triplet(int v, int ap, int vp) {
            this.val = v;
            this.aPos = ap;
            this.vPos = vp;
        }

        // MIN heap ordering by val
        @Override
        public int compareTo(Triplet other) {
            // safer than (this.val - other.val) to avoid overflow
            return Integer.compare(this.val, other.val);
        }
    }

    /*
     * Merges K sorted lists into one sorted list.
     */
    public static List<Integer> mergeArr(ArrayList<ArrayList<Integer>> arr) {

        List<Integer> result = new ArrayList<>();

        // Min heap based on Triplet.val
        PriorityQueue<Triplet> pq = new PriorityQueue<>();

        // 1) Push the first element of each list into heap
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != null && !arr.get(i).isEmpty()) {
                pq.offer(new Triplet(arr.get(i).get(0), i, 0));
            }
        }

        // 2) Extract-min and push next from same list
        while (!pq.isEmpty()) {

            Triplet curr = pq.poll();
            result.add(curr.val);

            int listIndex = curr.aPos;
            int nextIndex = curr.vPos + 1;

            // If there is a next element in the same list, push it
            if (nextIndex < arr.get(listIndex).size()) {
                pq.offer(new Triplet(arr.get(listIndex).get(nextIndex), listIndex, nextIndex));
            }
        }

        return result;
    }

    // Driver code for your IDE testing
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(10);
        a1.add(20);
        a1.add(30);
        arr.add(a1);

        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(5);
        a2.add(15);
        arr.add(a2);

        ArrayList<Integer> a3 = new ArrayList<>();
        a3.add(1);
        a3.add(9);
        a3.add(11);
        a3.add(18);
        arr.add(a3);

        List<Integer> res = mergeArr(arr);

        System.out.println("Merged array is:");
        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}