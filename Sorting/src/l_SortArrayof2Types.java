public class l_SortArrayof2Types {
    /*
    many types:
    separate even-odd, +ve - -ve, 0s-1s

    naive is create another arr and segregate accordingly!

    eff:
    apply hoare partition. start from 2 ends. find violating ones on both sides and swap
     */
    public static void main(String[] args) {
        int arr[] = new int[]{13, -12, 18, -10};

        int n = arr.length;

        sort(arr, n);

        for (int x : arr)
            System.out.print(x + " ");

    }

    static void sort(int arr[], int n) {
        int i = -1, j = n;
        while (true) {
            do {
                i++;
            } while (arr[i] < 0);
            do {
                j--;
            } while (arr[j] >= 0);
            if (i >= j) return;

            //swapping arr[i] & arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }

    }
}
