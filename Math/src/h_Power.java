public class h_Power {
    //TC: O(log n), AS: O(1)
    public static int power(int x, int y)
    {
        // Initialize result
        int res = 1;

        while (y > 0)
        {
            // If y is odd,
            // multiply
            // x with result
            if ((y & 1) == 1)
                res = res * x;

            // y must be even now
            y = y >> 1; // y = y/2
            x = x * x; // Change x to x^2
        }
        return res;
    }

    // Driver code
    public static void main(String[] args)
    {
        int x = 3;
        int y = 5;
        // Function call
        System.out.printf("%d", power(x, y));
    }
}

/*
// recursive solutions are generally not preferred
as they require space on call stack and they involve function call overhead

//TC: O(log n), AS: O(log n)
    public static int power(int x, int y)
    {
        int temp;
        if (y == 0)
            return 1;
        temp = power(x, y / 2);
        if (y % 2 == 0)
            return temp * temp;
        else
            return x * temp * temp;
    }

 */
