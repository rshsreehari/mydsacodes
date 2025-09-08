public class f_IntersectionofSortedArrays {
    public static void main(String[] args) {
        int a[] = new int[]{3, 5, 10, 10, 10, 15, 15, 20};
        int b[] = new int[]{5, 10, 10, 15, 30};

        int m = a.length;
        int n = b.length;
        intersection(a, b, m, n);

    }

    static void intersection(int a[], int b[], int m, int n) {

        int i = 0, j = 0;
        while (i < m && j < n) {
            /*
            no need to check in both arrays
            if one array is skipped the other common elements in another array
            will be handled in below if else-if conditions
             */

            if (i > 0 && a[i - 1] == a[i]) {
                i++;
                continue;
            }
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                System.out.print(a[i] + " ");
                i++;
                j++;
            }
        }

    }
}
