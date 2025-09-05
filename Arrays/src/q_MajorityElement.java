public class q_MajorityElement {
    //Moore's Voting Algorithm
    /*
    the main intuition is that:
    we start checking by considering arr[0] as majority element and
    check the count upon traversing further. If we find ele which
    is not equal to majority element which we considered we decrease count.
    In this, if we find count to be 0 anywhere, we will get then start considering that
    last element which gave us count 0 as new majority ele and continue traversing.

    In this way if any element exists as majority that will be founded out.
    ex: [7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5]
    There can also be exception where we will get the count and element but that
    can't be a majority element
    ex: [7,7,5,7,5,1,5,7,5,5,7,7,1,1,1,1]

    Thus, we check again separately if obtained ans is majority element or not.
     */

    /* Function to print Majority Element */
    void printMajority(int a[], int size)
    {
        /* Find the candidate for Majority*/
        int cand = findCandidate(a, size);

        /* Print the candidate if it is Majority*/
        if (isMajority(a, size, cand))
            System.out.println(" " + cand + " ");
        else
            System.out.println("No Majority Element");
    }

    /* Function to find the candidate for Majority */
    int findCandidate(int a[], int size)
    {
        int maj_index = 0, count = 1;
        int i;
        for (i = 1; i < size; i++) {
            if (a[maj_index] == a[i])
                count++;
            else
                count--;
            if (count == 0) {
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];
    }

    /* Function to check if the candidate occurs more
    than n/2 times */
    boolean isMajority(int a[], int size, int cand)
    {
        int i, count = 0;
        for (i = 0; i < size; i++) {
            if (a[i] == cand)
                count++;
        }
        if (count > size / 2)
            return true;
        else
            return false;
    }

    /* Driver code */
    public static void main(String[] args)
    {
        q_MajorityElement majorelement
                = new q_MajorityElement();
        int a[] = new int[] { 1, 3, 3, 1, 2 };

        // Function call
        int size = a.length;
        majorelement.printMajority(a, size);
    }
}
