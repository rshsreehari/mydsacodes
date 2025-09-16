public class q_HeapSort {
    /*

    **Still the GOAT explanation for heap is done by abdul bari**
    https://www.youtube.com/watch?v=HqPJF2L5h9U
    This is not a straight forward topic. Some prerequisites are needed to learn this.
    - Array rep of BT
    - Complete BT
    - Heap
    - Insert & delete
    - Heapsort
    - heapify
    - priority queue

    step to heap sort:
    - from normal array build a max heap
    - from that delete the max ele and store that in space which is available at end of the array
    - repeat the process for next large element
    - before deleting next large ele make sure its converted to max heap by heapify
    - this way you are indirectly sorting array by deleting the largest element and placing at space available

    Merge sort O(nlogn) in worst case
    Quick sort O(nlogn) on average case
    Heap sort O(nlogn) in all cases.

    Intro sort may use this as a hybrid algo because sometimes the TC may go beyond nlogn for quick sort in
    certain cases and this intro sort switches to heap sort in that case. this is used in c++ standard library

     */
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            swap(arr, i, largest);

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    // Main function for heap sort
    void heapSort(int arr[], int n)
    {
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            swap(arr, 0, i);

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Utility function to print array
    static void printArray(int arr[]) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        System.out.println("Original array:");
        printArray(arr);

        q_HeapSort ob = new q_HeapSort();
        ob.heapSort(arr, n);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
