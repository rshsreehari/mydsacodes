public class h_LomutoPartition {
    /*
    All these are very interesting and brain eating,
    This is best explained by Sandeep Jain sir!

    Just seeing code doesn't work recheck your notes.

    The main idea is that we partition the array considering last ele as pivot.
    The partition is done such that all ele less that that pivot are moved to left side of pivot and
    all ele greater than pivot will be moved right side. The pivot will be placed in exact position where its
    supposed to be when sorted. This is Lomuto partition!

    This is done by below logic:

    we consider last ele as pivot.
    start iterating the array from start
    2 cases:
    value >= pivot : do nothing. iterate forward
    value < pivot : i++ and swap the found value with arr[i] now.
    (here i keeps track of last ele which has value < pivot)

    at last swap back last ele (which is pivot) with i++
    this will bring pivot to its exact place.

    Thats it!

     */
    static int sort(int numbers[], int start, int last)
    {
        int pivot = numbers[last];
        int index = start - 1;
        int temp = 0;

        for (int i = start; i < last; ++i)
        {
            if (numbers[i] < pivot) {
                ++index;

                // swap the position
                temp = numbers[index];
                numbers[index] = numbers[i];
                numbers[i] = temp;
            }
        }

        int pivotposition = ++index;

        temp = numbers[index];
        numbers[index] = pivot;
        numbers[last] = temp;

        return pivotposition;
    }

    static void quicksort(int numbers[], int start, int end)
    {
        if (start < end)
        {
            int pivot_position = sort(numbers, start, end);
            quicksort(numbers, start, pivot_position - 1);
            quicksort(numbers, pivot_position + 1, end);
        }
    }

    static void print(int numbers[])
    {
        for (int a : numbers) {
            System.out.print(a + " ");
        }
    }

    public static void main(String[] args)
    {
        int numbers[] = { 4, 5, 1, 2, 4, 5, 6 };
        quicksort(numbers, 0, numbers.length - 1);
        print(numbers);
    }
}
