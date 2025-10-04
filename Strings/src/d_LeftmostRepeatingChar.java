public class d_LeftmostRepeatingChar {
    /*
    idea is to make a boolean array and mark it true when we find a ele and if found again make it the answer
    main logic is to iterate from right so that we get the left most repeating char
     */
    static final int CHAR=256;
    static int leftMost(String str)
    {
        boolean[] visited=new boolean[CHAR];
        int res=-1;
        for(int i=str.length()-1;i>=0;i--){
            if(visited[str.charAt(i)])
                res=i;
            else
                visited[str.charAt(i)]=true;
        }

        return res;

    }

    public static void main(String args[])
    {   String str = "geeksforgeeks";
        System.out.println("Index of leftmost repeating character:");
        System.out.println(leftMost(str));
    }
}
