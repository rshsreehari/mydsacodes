public class i_MedianOf2SortedArrays {
    /*
    Median is the middle number when arranged in ascending order.
    if odd count its middle number and if even count its average of 2 middle numbers
     */

    /*
    here we assume a1 has smaller size always, thus n1<=n2
    TC is O(logn1)

    idea is using binary search on smallest size array which is a1 we maintain 2 sets left and right half
    for left half we maintain left side of median from both arrays
    for right half we maintain right side of median from both arrays

    idea is to maintain equal number of ele in both halves and if even count we can maintain one more in
    left half

    There is a formula to get i2 from i1,n1,n2. See notes!

    When this binary search stops?
    This is stopped when all the element on left half are smaller than right half. How to verify that?
    Below:
    leftA -> Rightmost element in left part of A.
    leftb -> Rightmost element in left part of B
    rightA -> Leftmost element in right part of A
    rightB -> Leftmost element in right part of B
    Hence to confirm that the partition was correct we have to check if leftA<=rightB and leftB<=rightA.
     */


    // Method to find median
    static double Median(int[] A, int[] B)
    {
        int n = A.length;
        int m = B.length;
        if (n > m)
            return Median(B,
                    A); // Swapping to make A smaller

        int start = 0;
        int end = n;
        int realmidinmergedarray = (n + m + 1) / 2;

        while (start <= end) {
            int mid = (start + end) / 2;
            int leftAsize = mid;
            int leftBsize = realmidinmergedarray - mid;
            int leftA
                    = (leftAsize > 0)
                    ? A[leftAsize - 1]
                    : Integer
                    .MIN_VALUE; // checking overflow
            // of indices
            int leftB = (leftBsize > 0) ? B[leftBsize - 1]
                    : Integer.MIN_VALUE;
            int rightA = (leftAsize < n)
                    ? A[leftAsize]
                    : Integer.MAX_VALUE;
            int rightB = (leftBsize < m)
                    ? B[leftBsize]
                    : Integer.MAX_VALUE;

            // if correct partition is done
            if (leftA <= rightB && leftB <= rightA) {
                if ((m + n) % 2 == 0)
                    return (Math.max(leftA, leftB)
                            + Math.min(rightA, rightB))
                            / 2.0;
                return Math.max(leftA, leftB);
            }
            else if (leftA > rightB) {
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return 0.0;
    }

    // Driver code
    public static void main(String[] args)
    {
        int[] arr1 = { -5, 3, 6, 12, 15 };
        int[] arr2 = { -12, -10, -6, -3, 4, 10 };
        System.out.println("Median of the two arrays are");
        System.out.println(Median(arr1, arr2));
    }
}
