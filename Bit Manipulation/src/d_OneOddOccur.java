public class d_OneOddOccur {
    /*
    XOR rules:
    x^0=x
    x^y=y^x
    x^x=0
    x^x^x^x..(odd times)=x
    x^x^x^x..(even times)=0
     */
    int getOddOccurrence(int ar[], int ar_size)
    {
        int res = 0;
        for (int i = 0; i < ar_size; i++)
        {
            res = res ^ ar[i];
        }
        return res;
    }

    public static void main(String[] args)
    {
        d_OneOddOccur occur = new d_OneOddOccur();
        int ar[] = new int[]{2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
        int n = ar.length;
        System.out.println(occur.getOddOccurrence(ar, n));
    }
}
