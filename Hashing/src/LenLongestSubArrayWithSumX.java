import java.util.HashMap;
/*
*** returns just the length of longest sub array ***

The HashMap is used to store the sum and index at each instance and
we check total prefix sum - given sum and see if the acquired sum exist in the hash map

if exist we then get the length of that sum and check if its the longest or not and finally return it
 */

public class LenLongestSubArrayWithSumX {
    public static void main (String[] args)
    {
        int arr[] = new int[]{5, 8, -4, -4, 9, -2, 2};
        int n = arr.length;
        int sum = 0;

        System.out.println(largestSubarrayWithSumX(arr, n, sum));

    }

    static int largestSubarrayWithSumX(int[] arr, int n, int k)
    {
        // HashMap to store (sum, index) tuples
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        // traverse the given array
        for (int i = 0; i < n; i++) {

            // accumulate sum
            sum += arr[i];

            // when subarray starts from index '0'
            if (sum == k)
                maxLen = i + 1;

            // make an entry for 'sum' if it is
            // not present in 'map'
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            // check if 'sum-k' is present in 'map'
            // or not
            if (map.containsKey(sum - k)) {

                // update maxLength
                if (maxLen < (i - map.get(sum - k)))
                    maxLen = i - map.get(sum - k);
            }
        }

        return maxLen;
    }
}
