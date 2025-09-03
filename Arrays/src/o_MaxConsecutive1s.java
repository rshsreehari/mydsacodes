public class o_MaxConsecutive1s {
    /*
    every time we see 0 we make count 0 and
    every time we see 1 we increment count
    this way we get the ans

    there also exists an answer with bit manipulation
     */
    static int maxConsecutiveOnes(int arr[], int n) {
        int res = 0, curr = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                curr = 0;
            else {
                curr++;

                res = Math.max(res, curr);
            }
        }

        return res;
    }


    public static void main(String args[]) {
        int arr[] = {0, 1, 1, 0, 1, 1, 1}, n = 7;

        System.out.println(maxConsecutiveOnes(arr, n));


    }
}
