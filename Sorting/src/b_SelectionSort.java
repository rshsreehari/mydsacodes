public class b_SelectionSort {
    /*
    TC: O(n^2), AS: O(1)

    Selection sort major advantage of this algo is the space it uses. This is the least among any sorting algo
    Some places such as EEP ROM has very costly memory writes which decreases age of memory.
    There we can prefer this algo.

    This is the basic idea for heap sort!

    Selection sort is not stable and in place algo

    idea is to check for the smallest element in one iteration and fix that at first
    in next iteration check for next smallest and fix at second... so on
    each element is fixed at respective position by swapping with found element position
     */

    void sort(int arr[])
    {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // Prints the array
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver code to test above
    public static void main(String args[])
    {
        b_SelectionSort ob = new b_SelectionSort();
        int arr[] = {64,25,12,22,11};
        ob.sort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}
