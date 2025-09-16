import java.util.Arrays;

public class p_CycleSort {
    /*
    - this is a O(n^2) algo in worst case
    - no other algo does sorting in less memory writes as cycle sort does
    - in place and unstable
    - useful for questions like find min swaps to sort an array

    - when question has 1 to n then its damn sure related to cycle sort.
      trick to crack a problem by Kunal kushwaha
     */
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i , correct);
            } else {
                i++;
            }
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    
}
