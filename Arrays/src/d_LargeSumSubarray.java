public class d_LargeSumSubarray {
    // Function to find the largest sum contiguous subarray using Kadane's Algorithm
    public static int largestSum(int[] arr, int n) {
        int maxSoFar = Integer.MIN_VALUE;

        // Stores the maximum sum of subarray ending at the current position
        int maxEndingHere = 0;

        for (int i = 0; i < n; i++) {
            maxEndingHere += arr[i];

            // Update maxSoFar if the current subarray sum is greater
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }

            // If current subarray sum becomes negative, reset it to 0
            // (because a negative sum would decrease the sum of any future subarray)
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }

        // Return the maximum sum found
        return maxSoFar;
    }

    // Driver code to test
    public static void main(String[] args) {
        // Example array
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int n = arr.length;

        // Call function and store result
        int maxSum = largestSum(arr, n);

        // Print the result
        System.out.println("Largest sum of contiguous subarray: " + maxSum);
    }

    /*
    very imp: kadane's is also written in diff way.
    approach is simple!

    at every index in array check if we can start new subarray or
    continue with previous stack subarray to get the maximum sub array.

    This can be seen as below:

    public static int largestSum(int[] arr, int n) {
        int cursubsum = arr[0];
        int maxsubsum = arr[0];

        for (int i = 1; i < n; i++) {
            cursubsum = Math.max(cursubsum+arr[i],arr[i]);
            maxsubsum = Math.max(maxsubsum,cursubsum);
        }
        return maxsubsum;
        // Return the maximum sum found
        return maxsubsum;
    }

     */
}
