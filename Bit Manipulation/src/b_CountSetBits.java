public class b_CountSetBits {
    /*
    Brian Kernighan’s Algorithm : So if we subtract a number by 1 and
    do it bitwise & with itself (n & (n-1)), we unset the rightmost set bit.
    If we do n & (n-1) in a loop and count the number of times the loop executes, we get the set bit count.
     */
    public static int countSetBits(int n)
    {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    // driver program
    public static void main(String args[])
    {
        int i = 9;
        System.out.println(countSetBits(i));
    }
}
