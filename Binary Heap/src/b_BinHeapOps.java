import java.util.Arrays;

/**
 * b_BinHeapOps
 * ------------
 * Full Min-Heap (Binary Heap) operations in one place for revision.
 *
 * Data structure:
 *  - MinHeap stored in an array.
 *  - Heap property: arr[parent] <= arr[child]
 *
 * Index math:
 *  - left(i)  = 2*i + 1
 *  - right(i) = 2*i + 2
 *  - parent(i)= (i-1)/2
 *
 * Core operations included:
 *  - insert(x)        : add new element
 *  - minHeapify(i)    : fix heap going DOWN from index i
 *  - extractMin()     : remove + return min element (root)
 *  - decreaseKey(i,x) : decrease value at index i and fix heap going UP
 *  - deleteKey(i)     : delete element at index i (via decreaseKey + extractMin)
 *  - buildHeap()      : convert arbitrary array contents into a heap in O(n)
 */
public class b_BinHeapOps {

    static class MinHeap {
        int[] arr;      // storage array
        int size;       // number of valid elements in heap: indices [0..size-1]
        int capacity;   // max elements heap can hold (fixed)

        MinHeap(int c) {
            this.size = 0;
            this.capacity = c;
            this.arr = new int[c];
        }

        // -------- index helpers --------
        int left(int i)   { return 2 * i + 1; }
        int right(int i)  { return 2 * i + 2; }
        int parent(int i) { return (i - 1) / 2; }

        // Simple swap helper (keeps code readable)
        private void swap(int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        /**
         * insert(x)
         * ---------
         * Insert at end, then "bubble up" (sift up) until heap property is restored.
         * Time: O(log n)
         */
        public void insert(int x) {
            if (size == capacity) return; // heap full

            // Put at end
            arr[size] = x;
            int i = size;
            size++;

            // Bubble-up: while parent is bigger, swap upwards
            while (i != 0 && arr[parent(i)] > arr[i]) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        /**
         * minHeapify(i)
         * -------------
         * Fix heap property in subtree rooted at i by pushing arr[i] down.
         * Assumption: left subtree and right subtree are already heaps.
         * Time: O(log n)
         */
        public void minHeapify(int i) {
            int lt = left(i);
            int rt = right(i);
            int smallest = i;

            // Compare with left child
            if (lt < size && arr[lt] < arr[smallest]) {
                smallest = lt;
            }

            // Compare with right child
            if (rt < size && arr[rt] < arr[smallest]) {
                smallest = rt;
            }

            // If a child is smaller, swap and continue heapifying down
            if (smallest != i) {
                swap(i, smallest);
                minHeapify(smallest);
            }
        }

        /**
         * extractMin()
         * ------------
         * Remove and return the smallest element (root at index 0).
         *
         * Steps:
         *  1) Save root (min)
         *  2) Move last element to root
         *  3) size--
         *  4) heapify down from root
         *
         * Time: O(log n)
         */
        public int extractMin() {
            if (size <= 0) return Integer.MAX_VALUE; // empty heap
            if (size == 1) {
                size--;
                return arr[0];
            }

            int minVal = arr[0];      // save the min
            arr[0] = arr[size - 1];   // last -> root
            size--;                   // shrink heap
            minHeapify(0);            // restore heap property

            return minVal;            // return saved min (standard + correct)
        }

        /**
         * decreaseKey(i, x)
         * -----------------
         * Decrease value at index i to x (x should be <= current value),
         * then "bubble up" to restore heap property.
         * Time: O(log n)
         */
        public void decreaseKey(int i, int x) {
            if (i < 0 || i >= size) return; // invalid index guard

            arr[i] = x;

            // Bubble-up until heap property satisfied
            while (i != 0 && arr[parent(i)] > arr[i]) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        /**
         * deleteKey(i)
         * ------------
         * Delete element at index i.
         * Trick:
         *  1) decreaseKey(i, -infinity) so it becomes the smallest
         *  2) extractMin() removes it from root
         * Time: O(log n)
         */
        public void deleteKey(int i) {
            if (i < 0 || i >= size) return; // invalid index guard
            decreaseKey(i, Integer.MIN_VALUE);
            extractMin();
        }

        /**
         * buildHeap()
         * -----------
         * Convert current array contents (0..size-1) into a valid MinHeap.
         *
         * Key idea:
         *  - All leaves are already heaps.
         *  - Start from the last non-leaf node and heapify down each node.
         *
         * Last non-leaf index = (size-2)/2
         * Time: O(n)
         */
        public void buildHeap() {
            for (int i = (size - 2) / 2; i >= 0; i--) {
                minHeapify(i);
            }
        }

        /**
         * Optional helper for quick debugging / revision.
         * Shows only the valid heap portion (0..size-1).
         */
        public String toStringHeap() {
            return Arrays.toString(Arrays.copyOfRange(arr, 0, size));
        }
    }

    public static void main(String[] args) {
        MinHeap h = new MinHeap(11);

        // Insert demo
        h.insert(3);
        h.insert(2);
        h.insert(15);
        h.insert(20);
        // Heap should look like: [2, 3, 15, 20] (one valid min-heap layout)
        System.out.println("Heap after inserts: " + h.toStringHeap());

        // Delete key demo: delete element at index 0 (root)
        h.deleteKey(0); // deletes current min
        System.out.println("After deleteKey(0): " + h.toStringHeap());

        // Extract min demo
        System.out.println("extractMin(): " + h.extractMin());
        System.out.println("Heap now: " + h.toStringHeap());

        // Decrease key demo (ensure index exists)
        // If size >= 2, decrease an internal node
        if (h.size > 1) {
            h.decreaseKey(1, 1);
            System.out.println("After decreaseKey(1,1): " + h.toStringHeap());
            System.out.println("extractMin(): " + h.extractMin());
            System.out.println("Heap now: " + h.toStringHeap());
        }

        // BuildHeap demo:
        // Fill arr directly (like an unsorted array) then buildHeap.
        MinHeap h2 = new MinHeap(11);
        h2.arr[0] = 10;
        h2.arr[1] = 5;
        h2.arr[2] = 20;
        h2.arr[3] = 2;
        h2.arr[4] = 8;
        h2.size = 5; // IMPORTANT: size must reflect how many elements are "active"

        System.out.println("Before buildHeap: " + h2.toStringHeap());
        h2.buildHeap();
        System.out.println("After buildHeap:  " + h2.toStringHeap());
        System.out.println("extractMin(): " + h2.extractMin());
    }
}