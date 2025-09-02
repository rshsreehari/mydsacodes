public class b_Palindrome {
    public static boolean isPalindrome(String s, int i){
        /*
        if i has come to this case then all previous ones are satisfied which
        means a palindrome
         */
        if(i > s.length()/2)
        {
            return true ;
        }
        /*
        we are checking if ith index and n-i-1th index are equal or not
        every single time
         */
        return s.charAt(i) == s.charAt(s.length()-i-1) && isPalindrome(s, i+1) ;

    }

    public static void main (String[] args) {
        String str = "malayalam" ;
        if (isPalindrome(str, 0))
        { System.out.println("Yes"); }
        else
        { System.out.println("No"); }

    }
}
