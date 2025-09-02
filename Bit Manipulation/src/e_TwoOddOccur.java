public class e_TwoOddOccur {
    public static void oddAppearing(int arr[], int n)
    {
        int xor = 0, res1 = 0, res2 = 0;

        for (int i = 0; i < n; i++) {
            xor = xor ^ arr[i];
        }

        //gives right most set bit
        int sn = xor & (~(xor - 1));

        for (int i = 0; i < n; i++)
        {
            //groups the integers which have 1 at that right most bit position
            if ((arr[i] & sn) != 0)
                res1 = res1 ^ arr[i];
            //groups the integers which have 0 at that right most bit position
            else
                res2 = res2 ^ arr[i];
        }
        /*
        rest all numbers will be gone in any one group, and we do not care because they
        will get cancelled out
         */
        System.out.println( res1 + " " + res2);
    }
    public static void main (String[] args) {

        int arr[]= {3, 4, 3, 4, 5, 4, 4, 6, 7, 7}, n = 10;

        oddAppearing(arr, n);
    }
}
