import java.util.Arrays;

public class k_ChocolateDistribution {
    /*
    arr[i] = no. of chocolates in ith packet
    each packet has variable num of chocolates
    m students present
    task is distribute them so that
    - each student has exactly one packet
    - diff b/w min and max no. of chocolates given to students is minimized
    i.e max of chosen - min of chosen

    naive idea:
    consider every ele as min. Find the closest m-1 items for that ele such that
    the diff is minimum. Now do the same for every ele in array. Find the min of all.

    eff idea:
    sort the array. check the diff for m-1 ele from first index till end
    now get the min.

    i.e after sorting the best group of m packets must be consecutive in
        the sorted array.
     */
    public static void main(String[] args) {
        int arr[] = new int[]{7, 3, 2, 4, 9, 12, 56};

        int n = arr.length;
        int m = 3;

        System.out.print(minDiff(arr, n, m));

    }

    static int minDiff(int arr[], int n, int m) {
        if (m > n)
            return -1;
        Arrays.sort(arr);
        int res = arr[m - 1] - arr[0];
        for (int i = 0; (i + m - 1) < n; i++)
            res = Math.min(res, arr[i + m - 1] - arr[i]);
        return res;

    }
}
