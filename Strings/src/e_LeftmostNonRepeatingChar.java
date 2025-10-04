import java.util.Arrays;

public class e_LeftmostNonRepeatingChar {
    /*
    create a 256 size array, fill the arr with -1
    iterate the string and if chars is found 1st time mark it with index and if found  second time mark it as -2
    After all check for the least positive index in the 256 array
     */
    static final int CHAR=256;
    static int nonRep(String str)
    {
        int[] fI=new int[CHAR];
        Arrays.fill(fI,-1);

        for(int i=0;i<str.length();i++){
            if(fI[str.charAt(i)]==-1)
                fI[str.charAt(i)]=i;
            else
                fI[str.charAt(i)]=-2;
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<CHAR;i++){
            if(fI[i]>=0)res=Math.min(res,fI[i]);
        }
        return (res==Integer.MAX_VALUE)?-1:res;
    }

    public static void main(String args[])
    {   String str = "geeksforgeeks";
        System.out.println("Index of leftmost non-repeating element:");
        System.out.println(nonRep(str));
    }

}
