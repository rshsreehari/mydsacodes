public class j_SortedRotatedArray {
    /*
    rotated means it will be rotated clock wise
    goal is to find an ele from that.

    Linear search can do that but even more optimised is binary search on this!

    Every single line and condition is perfectly well-packed in this code.
    forget a single edge case or condition, you will miss the code

    By sorted rotated array we can say at any time one side of array is sorted.
    We check that sorted side and decide the high and low variables accordingly
     */
    static int search(int arr[], int n, int x)
    {
        int low = 0, high = n - 1;

        while(low <= high)
        {
            int mid = (low + high) / 2;
            //classic binary search till here
            if(arr[mid] == x)
                return mid;
            /*
            now game starts:
            firstly we check which side is sorted. To check that we can compare middle and initial element
            we jump into that sorted side no matter what.

            Now, for each side 2 cases are present. Either low or high will be updated according to value.
            Check if the target is present in range between sorted side or not and update the low and high
            accordingly for both cases i.e left sorted or right sorted
            */
            if(arr[low] <= arr[mid])    //not adding = here costed me this case: [3,1]
            {
                if(x >= arr[low] && x < arr[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            else
            {
                if(x > arr[mid] && x <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }


        return -1;
    }

    public static void main(String args[])
    {

        int arr[] = {10, 20, 40, 60, 5, 8}, n = 6;

        int x = 5;

        System.out.println(search(arr, n, x));

    }
}
