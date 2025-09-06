public class a_BubbleSort {
    /*
    TC: O(n^2)
    Bubble sort is stable and in place algorithm
    its stable because it wont change the order
    its inplace because it doesn't need any extra space to modify the array

    idea is to compare ith and (i+1)th element and swap when ith element is greater
    after 1st iteration larger ele will come to last
    next iteration next larger will come to last but one
    ...so on
     */
    void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            //here n-i-1 is considered coz for every iteration we fix one more num towards the end
            //so no need to iterate fixed numbers
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    /* Prints the array */
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method to test above
    public static void main(String args[])
    {
        a_BubbleSort ob = new a_BubbleSort();
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        ob.bubbleSort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}
