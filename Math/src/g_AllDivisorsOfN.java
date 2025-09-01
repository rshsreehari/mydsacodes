import java.util.Scanner;

public class g_AllDivisorsOfN {
    //printing divisors in sorted manner
    static void printFactors(int n) {
        int i;
        for (i = 1; i * i <= n; i++) {
            if (n % i == 0) {System.out.print(i + " ");}
        }
        for (; i > 1; i--) {
            if (i != n / i && n % i == 0) {System.out.print(n / i + " ");}
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printFactors(n);
    }
}
/*
if order is not imp(unsorted order)

	public static void printDivisors(int n)
	{
		for(int i=1; i*i <= n; i++)
		{
			if(n % i == 0)
			{
				System.out.print(i+" ");

				if(i != n / i)
					System.out.print((n / i)+" ");
			}
		}
	}
 */
