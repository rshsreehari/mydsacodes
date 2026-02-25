import java.util.Arrays;

public class i_2_MergeSort {

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        qsort(nums, 0, nums.length - 1);
        return nums;
    }

    private void qsort(int[] nums, int l, int r) {
        //this means atleast 2 elements needed to sort
        //if not nothing there to do
        if (l < r) {
            int p = partition(nums, l, r);
            qsort(nums, l, p);
            qsort(nums, p + 1, r);
        }
    }

    // Hoare partition
    private int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        int i = l - 1, j = r + 1;

        while (true) {
            do { i++; } while (arr[i] < pivot);
            do { j--; } while (arr[j] > pivot);

            if (i >= j) return j;
            swap(arr, i, j);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // ---- Example run ----
    public static void main(String[] args) {
        i_2_MergeSort sol = new i_2_MergeSort();

        int[] nums = {5, 1, 4, 2, 8, 3};
        System.out.println("Before sort: " + Arrays.toString(nums));

        sol.sortArray(nums);

        System.out.println("After sort:  " + Arrays.toString(nums));
    }
}
