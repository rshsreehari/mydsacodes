public class m_SortArrayof3Types {
    /*
    3 types:
    sort 0s,1s,2s
    3 way partition
    partition around range

    naive is same as previous

    eff:
    Apply Hoare partition. Famous problem is dutch flag problem.
    We need to check for a way to partition 0s,1s,2s.
    A variant of this partition can do that. Consider 3 variables. low,high,med.
    All 0s lie b/w low and med.
    ALl 1s in med to high and all 2s in high to n-1.
    mid and high move towards each other, and we stop when crossed.
     */

    public static void main(String[] args) {
        int arr[] = new int[]{0, 1, 1, 2, 0, 1, 1, 2};

        int n = arr.length;

        sort(arr, n);

        for (int x : arr)
            System.out.print(x + " ");

    }

    static void sort(int arr[], int n) {
        int l = 0, h = n - 1, mid = 0;
        while (mid <= h) {
            switch (arr[mid]) {
                case 0:
                    //swapping arr[l] & arr[mid])
                    int temp = arr[l];
                    arr[l] = arr[mid];
                    arr[mid] = temp;

                    l++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    //swapping arr[h] & arr[mid])
                    temp = arr[h];
                    arr[h] = arr[mid];
                    arr[mid] = temp;

                    h--;
                    break;
            }
        }


    }
}
