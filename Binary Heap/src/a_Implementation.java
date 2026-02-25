public class a_Implementation {

    /**
     * MinHeap (Array-based)
     * ---------------------
     * Heap property (MinHeap): parent <= children
     *
     * Array mapping:
     *   parent(i) = (i-1)/2
     *   left(i)   = 2*i + 1
     *   right(i)  = 2*i + 2
     */
    static class MinHeap {

        int[] arr;      // stores heap elements
        int size;       // current number of elements in heap (valid indices: 0..size-1)
        int capacity;   // maximum number of elements heap can hold (fixed)

        // Constructor: create empty heap with given capacity
        MinHeap(int c) {
            size = 0;
            capacity = c;
            arr = new int[c];
        }

        // Index helpers
        int left(int i)   { return 2 * i + 1; }
        int right(int i)  { return 2 * i + 2; }
        int parent(int i) { return (i - 1) / 2; }

        /**
         * INSERT(x)
         * ---------
         * 1) Put x at the end of the heap array (arr[size])
         * 2) size++
         * 3) Bubble-up (sift-up): while parent > child, swap upwards
         *
         * Time: O(log n)
         */
        public void insert(int x) {

            // Heap full -> cannot insert
            if (size == capacity) return;

            // Step 1: place at end
            arr[size] = x;
            int i = size;

            // Step 2: grow heap
            size++;

            // Step 3: bubble up to fix heap property
            while (i != 0 && arr[parent(i)] > arr[i]) {
                int temp = arr[i];
                arr[i] = arr[parent(i)];
                arr[parent(i)] = temp;

                i = parent(i); // move up
            }
        }

        /**
         * minHeapify(i)
         * -------------
         * Used when node at i might violate heap property by being larger than its children.
         * We push it down until the subtree rooted at i becomes a valid MinHeap.
         *
         * Steps:
         * 1) Find smallest among i, left child, right child
         * 2) If a child is smaller than arr[i], swap and continue heapify down
         *
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

            // If parent is not smallest, swap and continue down
            if (smallest != i) {
                int temp = arr[i];
                arr[i] = arr[smallest];
                arr[smallest] = temp;

                // Recursively heapify the affected subtree
                minHeapify(smallest);
            }
        }

        /**
         * extractMin()
         * ------------
         * Removes and returns the minimum element (root = arr[0]).
         *
         * Steps:
         * 1) If empty -> return MAX_VALUE (sentinel)
         * 2) Save root (min)
         * 3) Move last element to root
         * 4) size--
         * 5) heapify down from root to restore heap property
         *
         * Time: O(log n)
         */
        public int extractMin() {

            // Empty heap
            if (size <= 0) return Integer.MAX_VALUE;

            // Only one element
            if (size == 1) {
                size--;
                return arr[0];
            }

            // Step 2: save min
            int minVal = arr[0];

            // Step 3: move last element to root
            arr[0] = arr[size - 1];

            // Step 4: shrink heap
            size--;

            // Step 5: fix heap property by pushing root down
            minHeapify(0);

            // IMPORTANT: return the saved min (standard + correct)
            return minVal;
        }
    }

    public static void main(String[] args) {

        MinHeap h = new MinHeap(11);

        h.insert(3);
        h.insert(2);
        h.insert(15);
        h.insert(20);

        // Should print 2 (min element)
        System.out.println(h.extractMin());
    }
}