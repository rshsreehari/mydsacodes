public class e_MergeSortedArrays {
    // Method to merge two sorted arrays
    public static int[] mergeSorted(int[] arr1, int[] arr2, int m, int n) {
        int[] arr3 = new int[m + n]; // merged array
        int i = 0, j = 0, k = 0;

        // Merge while both arrays have elements
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }

        // Copy remaining elements of arr1, if any
        while (i < m) {
            arr3[k++] = arr1[i++];
        }

        // Copy remaining elements of arr2, if any
        while (j < n) {
            arr3[k++] = arr2[j++];
        }

        return arr3;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8, 10};

        int[] merged = mergeSorted(arr1, arr2, arr1.length, arr2.length);

        System.out.print("Merged Array: ");
        for (int num : merged) {
            System.out.print(num + " ");
        }
    }
}
