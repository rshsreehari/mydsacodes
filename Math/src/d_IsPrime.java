public class d_IsPrime {
    /*
    Divisors always occur in pairs, so we can restrict the checking only to sqrt(n)
    if x*y=n, if x<=y then x^2<=n and x<=sqrt(n)
    so if not found before sqrt(n) its a prime
     */
    public static boolean isPrime(int n) {
        if (n == 1)
            return false;

        if (n == 2 || n == 3)
            return true;
         /*
        for large n, sqrt(n) is also big so we optimise more
        check for 2,3 multiples directly
        start from 5 and jump 6 every time
        check inside for 5,7
         */

        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 1031;
        System.out.println(isPrime(n));


    }
}
