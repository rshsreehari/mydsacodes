public class i_PrintPermutation {
    public static void main(String[] args)
    {
        String str = "ABCD";
        int n = str.length();
        i_PrintPermutation permutation = new i_PrintPermutation();
        permutation.permute(str, 0, n-1);
    }

    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private void permute(String str, int l, int r)
    {
        //base case, we stop here
        /*
        put everything on paper on else u won't understand this
         */
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                //swapping A with all B,C,D and permute again
                str = swap(str,l,i);
                permute(str, l+1, r);
                //tricky: why swap back?
                /*
                at base case this will go to above condition and then we print
                the string as is. This string will be diff from what we pass
                and to retain the passed string we swap back
                **see notes for more clarity**
                 */
                str = swap(str,l,i);
            }
        }
    }

    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
