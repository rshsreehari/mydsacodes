/*
Idea is to find the maximum subarray sum in the array
 */
import java.util.*;

public class v_KadanesAlgo {
    // Function to find maximum sum of subarrays
    public int maxSubArray(int[] nums) {

        // Maximum sum
        int ans = Integer.MIN_VALUE;


        // Current sum of subarray
        int curr_sum = 0;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {

            // Add current element to the sum
            curr_sum += nums[i];

            // Update maxi if current sum is greater
            ans = Math.max(ans,curr_sum);

            // Reset sum to 0 if it becomes negative
            if (curr_sum < 0) {curr_sum=0;}
        }

        // Return the maximum subarray sum found
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        // Create an instance of Solution class
        v_KadanesAlgo sol = new v_KadanesAlgo();

        int maxSum = sol.maxSubArray(arr);

        // Print the max subarray sum
        System.out.println("The maximum subarray sum is: " + maxSum);
    }
}