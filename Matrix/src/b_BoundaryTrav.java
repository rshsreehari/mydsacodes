public class b_BoundaryTrav {
    /*
     idea is to print the boundary in anti clock wise direction
     */
    static int R = 4, C = 4;

    static void bTraversal(int mat[][])
    {
        //special case where there is only one row
        if(R == 1)
        {
            for(int i = 0; i < C; i++)
                System.out.print(mat[0][i] + " ");
        }
        //special case where there is only one column
        else if(C == 1)
        {
            for(int i = 0; i < R; i++)
                System.out.print(mat[i][0] + " ");
        }
        else
        {
            for(int i = 0; i < C; i++)
                System.out.print(mat[0][i] + " ");
            for(int i = 1; i < R; i++)
                System.out.print(mat[i][C - 1] + " ");
            for(int i = C - 2; i >= 0; i--)
                System.out.print(mat[R - 1][i] + " ");
            for(int i = R - 2; i >= 1; i--)
                System.out.print(mat[i][0] + " ");
        }

    }

    public static void main(String args[])
    {
        int arr[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        bTraversal(arr);
    }

}
