public class r_MinGroupFlipstoMakeSame {
    /*
    understand the problem first. This is asking minimum number of groups
    to flip. Not the count inside groups. So count the groups and check accordingly.

    This is done by observing some facts. They are:
    - Groups counts Maximum differ by  one or else equal

    eff idea: Its always efficient to flip second group, coz it is the ideal way to flip in both cases
    the flipping of second group makes minimum flips
     */

    public static void printGroups(int arr[], int n)
    {

        // Traverse through all array elements
        // starting from the second element
        for(int i = 1; i < n; i++)
        {

            // If current element is not same
            // as previous
            if (arr[i] != arr[i - 1])
            {

                // If it is same as first element
                // then it is starting of the interval
                // to be flipped.
                if (arr[i] != arr[0])
                    System.out.print("From " + i + " to ");

                    // If it is not same as previous
                    // and same as first element, then
                    // previous element is end of interval
                else
                    System.out.println(i - 1);
            }
        }

        // Explicitly handling the end of
        // last interval
        if (arr[n - 1] != arr[0])
            System.out.println(n - 1);
    }

    // Driver code
    public static void main(String[] args)
    {
        int arr[] = {0, 1, 1, 0, 0, 0, 1, 1};
        int n = arr.length;

        printGroups(arr, n);
    }

}
