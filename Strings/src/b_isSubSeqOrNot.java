import java.util.Scanner;

public class b_isSubSeqOrNot {
    /*
    The idea is to check if the second string is subsequence or not by iterating respective string when matched
    when we are out of iteration length in any one string we can get the answer subseq or not
     */
    static boolean isSubSeq(String s1, String s2, int n, int m){
        int j = 0;
        for(int i = 0; i < n && j < m; i++){
            if(s1.charAt(i) == s2.charAt(j))
                j++;
        }

        return j == m;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();

        String s1, s2;
        s1 = sc.next();
        s2 = sc.next();

        System.out.println(isSubSeq(s1, s2, n, m));

    }

}

