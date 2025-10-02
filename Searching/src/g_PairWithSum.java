public class g_PairWithSum {
    /*
    we can use 2 poniter approach here. We start from front and back side with help of 2 pointers and we check
    if sum is equal to target or not.
    If equal we return
    if less than, we increase i
    if greater than, we decrease j
     */
    public int[] twoSum(int[] numbers, int target) {
        //ans array having indices
        int[] ans = new int[2];
        int i = 0, j = numbers.length - 1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                ans[0] = i;
                ans[1] = j;
                break;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }

    // Simple test
    public static void main(String[] args) {
        g_PairWithSum solver = new g_PairWithSum();
        int[] res = solver.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(res[0] + " " + res[1]); // Output: 1 2
    }

}
