public class k_MaxDiffProb {
    /*
    idea is to keep track of min number till now and find difference b/w
    every element and min number till now
    instead of diff b/w every pair
     */
    int maxDiff(int arr[], int arr_size)
    {
        int max_diff = arr[1] - arr[0];
        int min_element = arr[0];
        int i;
        for (i = 1; i < arr_size; i++)
        {
            if (arr[i] - min_element > max_diff)
                max_diff = arr[i] - min_element;
            if (arr[i] < min_element)
                min_element = arr[i];
        }
        return max_diff;
    }

    /* Driver program to test above functions */
    public static void main(String[] args)
    {
        k_MaxDiffProb maxdif = new k_MaxDiffProb();
        int arr[] = {1, 2, 90, 10, 110};
        int size = arr.length;
        System.out.println("Max diff is " +
                maxdif.maxDiff(arr, size));
    }
}
