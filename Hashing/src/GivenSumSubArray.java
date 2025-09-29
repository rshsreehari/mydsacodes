import java.util.HashSet;
import java.util.Set;

/*
The hashset is maintained such that the prefix sum is pushed at every stage and we can check
if total prefix sum - current sum exists in hash set or not to confirm a subarray with given sum exists!
 */

public class GivenSumSubArray {
    public static void main(String[] args) {
        int arr[] = new int[]{5, 8, 6, 13, 3, -1};
        int sum = 22;
        int n = arr.length;

        System.out.println(isSum(arr, n, sum));

    }

    static boolean isSum(int arr[], int n, int sum) {
        Set<Integer> s = new HashSet<Integer>();
        int pre_sum = 0;
        for (int i = 0; i < n; i++) {
            pre_sum += arr[i];
            if (pre_sum == sum)
                return true;
            if (s.contains(pre_sum - sum) == true)
                return true;

            s.add(pre_sum);
        }

        return false;

    }
}
