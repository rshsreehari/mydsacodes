public class u_MaxAppearingEle {
    /*
    understand the problem first
    It will give the range values as 2 arrays
    left range in l[] and right range in r[]
    now for each range gather all the values present in it and
    return max appearing element(if multiple print first ele)
     */
    /*
    the eff idea for this is very tough to strike
    even if you know that we are using prefix sum
    So think properly!
     */
    /*
    idea is that we mark starting of a range as 1 and end+1 of range as -1
    Now we do that for all ranges and at last we calculate prefix sum for
    this freq array.
    we will get the frequencies of the numbers appeared in the range!!
     */
    static int MAX = 1000000;
    // Return the maximum occurred element in all ranges.
    static int maximumOccurredElement(int[] L, int[] R,
                                      int n)
    {
        // Initialising all element of array to 0.
        int[] arr = new int[MAX];

        // Adding +1 at Li index and
        // subtracting 1 at Ri index.
        int maxi = -1;
        for (int i = 0; i < n; i++) {
            arr[L[i]] += 1;
            arr[R[i] + 1] -= 1;
            if (R[i] > maxi) {
                maxi = R[i];
            }
        }

        // Finding prefix sum and index
        // having maximum prefix sum.
        int msum = arr[0];
        int ind = 0;
        for (int i = 1; i < maxi + 1; i++) {
            arr[i] += arr[i - 1];
            if (msum < arr[i]) {
                msum = arr[i];
                ind = i;
            }
        }

        return ind;
    }

    // Driver program
    static public void main(String[] args)
    {
        int[] L = { 1, 4, 9, 13, 21 };
        int[] R = { 15, 8, 12, 20, 30 };
        int n = L.length;
        System.out.println(maximumOccurredElement(L, R, n));
    }
}
