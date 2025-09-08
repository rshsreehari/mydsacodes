public class g_CountInversions {
    /*
    This is best explained by striver!

    Inversion: i<j and arr[i]>arr[j]

    In this the main logic is that we can count inversions by comparing 2 arrays
    which are already sorted. This way if we find someone from left array which has
    value > the one in right array, we will add not just 1 to result but also size of left array - index of that ele
    This is because if that value has inversion pair all the values above it will also have inversions!
    This way we can count inversions, and we take advantage of the fact that arrays are sorted.

    Now code is almost similar to merge sort and upon that we add above logic!
     */
    public static void main(String[] args) {
        int arr[] = new int[]{2, 4, 1, 3, 5};

        int n = arr.length;
        System.out.print(countInv(arr, 0, n - 1));

    }

    static int countInv(int arr[], int l, int r) {
        int res = 0;
        if (l < r) {

            int m = (r + l) / 2;

            res += countInv(arr, l, m);
            res += countInv(arr, m + 1, r);
            res += countAndMerge(arr, l, m, r);
        }
        return res;
    }

    static int countAndMerge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++)
            left[i] = arr[i + l];
        for (int j = 0; j < n2; j++)
            right[j] = arr[m + 1 + j];
        int res = 0, i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                res = res + (n1 - i);
            }
        }
        while (i < n1)
            arr[k++] = left[i++];
        while (j < n2)
            arr[k++] = right[j++];
        return res;

    }
}
