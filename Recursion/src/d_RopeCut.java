public class d_RopeCut {
    /*
    prob: Given a rope of length N meters, and the rope can be cut in only 3 sizes A, B and C.
    The task is to maximizes the number of cuts in rope.
    If it is impossible to make cut then print the number else print -1
     */
    //DP is better solution for this but just doing here to understand better
    public static int maxCuts(int n, int a, int b, int c)
    {
        if(n == 0)
            return 0;
        if(n <= -1)
            return -1;
        /*
        we decrease length only by a,b,c recursively
        we check if we find 0 at last and if found, that is
        a valid cut and if it goes <0 its invalid
         */
        int res = Math.max(maxCuts(n-a, a, b, c),
                Math.max(maxCuts(n-b, a, b, c),
                        maxCuts(n-c, a, b, c)));

        if(res == -1)
            return -1;
        /*
        why increment here but not while checking max?
        coz there is an edge case (ex: n=9, a=b=c=2)
        here the max returned value is -1 and if we increment there
        it becomes 0(which is false). so incr here!!
         */
        return res + 1;
    }
    public static void main(String [] args)
    {
        int n = 5, a = 2, b = 1, c = 5;

        System.out.println(maxCuts(n, a, b, c));

    }

}
