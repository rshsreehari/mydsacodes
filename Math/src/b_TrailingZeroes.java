// Java program to count
// trailing 0s in n!

public class b_TrailingZeroes {
    /*
    Function to return trailing 0s in factorial of n
     */
    public static int findTrailingZeros(int n)
    {
        if (n < 0) // Negative Number Edge Case
            return -1;

        // Initialize result
        int count = 0;

        // Keep dividing n by powers
        // of 5 and update count
        /*
        Why? Because 10 = 5*2 and number of 5's alone can get us num of 0's
         */
        for (int i = 5; n / i >= 1; i *= 5)
            count += n / i;

        return count;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int n = 50;
        System.out.println("Count of trailing 0s in " + n
                + "! is "
                + findTrailingZeros(n));
    }
}
