public class c_InsertionSort {
    /*
    Insertion sort is in place and stable algo
    It has O(n^2) TC in worst case and O(n) TC in best case

    This is popular and preferred for small size arrays

    idea is consider 2 parts sorted and unsorted. at every iter we take the element from
    unsorted part and try to fit that into sorted part at correct position.

    This may take high TC but this is very imp concept to understand
     */
    void sort(int arr[])
    {
        int n = arr.length;
        //start iter from 1 coz single ele at 0 is always sorted
        for (int i = 1; i < n; ++i) {
            int key = arr[i];       //curr ele will be key
            int j = i - 1;

            //iter backwards to check where the key fits correctly
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /* A utility function to print array of size n*/
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    // Driver method
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6 };

        c_InsertionSort ob = new c_InsertionSort();
        ob.sort(arr);

        printArray(arr);
    }
}
