import java.util.Arrays;
// goal is to find all the prime numbers which are smaller than given number
public class f_SeiveOfEratosthenes {
    public static void sieve(int n) {
        if (n <= 1) {
            return;
        }
        boolean isPrime[] = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j <= n; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        int n = 100;
        sieve(n);
    }
}
/*
Even more optimised code: (TC everything is same as above, but code wise optimised)
    public static void sieve(int n) {
        if (n <= 1) {
            return;
        }
        boolean isPrime[] = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i <= n; i++) {      //i>sqrt(n) inner loop wont run and just prints primes if any
            if (isPrime[i]) {
                System.out.print(i + " ");
                for (int j = i * i; j <= n; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }
    }
 */

