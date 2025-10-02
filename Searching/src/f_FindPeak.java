public class f_FindPeak {
    /*
    The idea is to give any peak element as the answer.
    So the peak need not be global, it can be local peak.
    To get that we will find mid every time and peak is to left side we move left and if peak is
    on right side we move right.
    Moving left/right doesnt mean that there is no other peak on right/left. Its just that we are sure
    there is a peak on left/right side of mid
     */
    static int getPeak(int arr[], int n)
    {
        int low = 0, high = n - 1;

        while(low <= high)
        {
            int mid = (low + high) / 2;

            //must be written in single if statement like this
            //check why by this example [1,2]
            if((mid == 0 || arr[mid - 1] <= arr[mid]) &&
                    (mid == n - 1 || arr[mid + 1] <= arr[mid]))
                return mid;
            if(mid > 0 && arr[mid - 1] >= arr[mid])
                high = mid -1;
            else
                low = mid + 1;
        }

        return -1;
    }

    public static void main(String args[])
    {

        int arr[] = {5, 20, 40, 30, 20, 50, 60}, n = 7;

        System.out.println(getPeak(arr, n));

    }
}
