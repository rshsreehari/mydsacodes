public class f_PowerSet {
    public static void printPowerSet(String str)
    {
        int n = str.length();
        int powSize = (int)Math.pow(2, n);  //.pow return double

        for(int counter = 0; counter < powSize; counter++)
        {
            //we check for bits only till n-1 as we have only n bits
            for(int j = 0; j < n; j++)
            {
                /*
                when counter=0; prints empty string
                when counter=001; checks for j (0,1,2)
                .
                .
                .
                ultimately we are checking where are the set bits for given power (0 to 2^n) and
                printing those chars at that position for string
                 */
                if((counter & (1 << j)) != 0)
                    System.out.print(str.charAt(j));
            }
            System.out.println();
        }
    }

    public static void main(String args[])
    {
        String s = "abc";
        printPowerSet(s);
    }
}
/*
counter:
000
001
010
011
100
101
110
111
j: 0,1,2
 */
