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
}
