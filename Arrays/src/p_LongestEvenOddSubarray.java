public class p_LongestEvenOddSubarray {
    /*
    idea is to keep track of variable to store count by checking previous
    and current ele. If both are even/odd make count 1 and if not increment
     */
    public static int maxEvenOdd(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }

        int maxLength = 1;  // Start with a minimum length of 1
        int currLen = 1;    // Current alternating sequence length

        for (int i = 1; i < n; i++) {
            // Check if the current element is alternating with the previous one
            if (arr[i] % 2 != arr[i - 1] % 2) {
                currLen++;  // Continue the alternating sequence
            } else {
                maxLength = Math.max(maxLength, currLen);  // Update maxLength if needed
                currLen = 1;  // Reset current sequence length
            }
        }
        // Final check for the last sequence
        /*
        this is needed coz if we find max till last ele and if not updated
        we will stay with old length only. So update after loop is needed
         */
        maxLength = Math.max(maxLength, currLen);

        // If maxLength is 1, no valid alternating subarray exists
        if (maxLength == 1) {
            return 0;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 3, 7, 2, 9, 4 };
        int n = arr.length;
        System.out.println("Length of longest subarray of even and odds is : " +
                maxEvenOdd(arr, n));
    }
}
