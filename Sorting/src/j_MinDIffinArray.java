import java.util.Arrays;

public class j_MinDIffinArray {
    /*
    easy sum!
     */
    // Returns minimum difference between any pair
    static int findMinDiff(int[] arr, int n)
    {
        // Sort array in non-decreasing order
        Arrays.sort(arr);

        // Initialize difference as infinite
        int diff = Integer.MAX_VALUE;

        // Find the min diff by comparing adjacent
        // pairs in sorted array
        for (int i = 0; i < n - 1; i++)
            if (arr[i + 1] - arr[i] < diff)
                diff = arr[i + 1] - arr[i];

        // Return min diff
        return diff;
    }

    // Driver code
    public static void main(String[] args)
    {
        int arr[] = new int[] { 1, 5, 3, 19, 18, 25 };

        // Function call
        System.out.println("Minimum difference is "
                + findMinDiff(arr, arr.length));
    }
}