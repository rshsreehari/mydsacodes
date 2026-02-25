public class c_HeapSort {

    /*
     * ===============================
     *        HEAP SORT
     * ===============================
     *
     * Time Complexity:
     *   Build Heap   -> O(n)
     *   Sorting      -> O(n log n)
     *   Overall      -> O(n log n)
     *
     * Space Complexity:
     *   O(1) (In-place sorting)
     *
     * Idea:
     *   1. Build a Max Heap from the array
     *   2. Move root (largest element) to end
     *   3. Reduce heap size
     *   4. Heapify root again
     */

    // ===============================
    // STEP 1: BUILD MAX HEAP
    // ===============================
    // Convert given array into Max Heap
    private void buildHeap(int[] arr, int n) {

        // Start from last non-leaf node
        // Index of last non-leaf node = (n/2) - 1
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    // ===============================
    // STEP 2: HEAP SORT
    // ===============================
    public void sort(int[] arr) {

        int n = arr.length;

        // Step 1: Build Max Heap
        buildHeap(arr, n);

        // Step 2: Extract elements one by one
        for (int i = n - 1; i > 0; i--) {

            // Move current root (largest) to end
            swap(arr, 0, i);

            // Call heapify on reduced heap
            heapify(arr, i, 0);
        }
    }

    // ===============================
    // HEAPIFY FUNCTION
    // ===============================
    /*
     * Maintains Max Heap property.
     *
     * arr[]  -> array
     * n      -> heap size
     * i      -> index to heapify
     */
    private void heapify(int[] arr, int n, int i) {

        int largest = i;          // Assume current node is largest
        int left = 2 * i + 1;     // Left child
        int right = 2 * i + 2;    // Right child

        // Check if left child exists and is greater
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check if right child exists and is greater
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {

            // Swap root with largest child
            swap(arr, i, largest);

            // Recursively heapify affected subtree
            heapify(arr, n, largest);
        }
    }

    // ===============================
    // SWAP HELPER METHOD
    // ===============================
    private void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // ===============================
    // PRINT ARRAY
    // ===============================
    private static void printArray(int[] arr) {

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // ===============================
    // MAIN METHOD (DRIVER CODE)
    // ===============================
    public static void main(String[] args) {

        int[] arr = {12, 11, 13, 5, 6, 7};

        c_HeapSort heapSort = new c_HeapSort();
        heapSort.sort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}