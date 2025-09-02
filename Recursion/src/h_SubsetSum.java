public class h_SubsetSum {
    /*
    the same logic used for generating subsets
    but we keep track of sum and when 0, its valid
    always recommend to draw the recursion tree
     */
    public static int countSubsets(int arr[], int n, int sum)
    {
        if(n==0)
            return sum==0? 1 : 0;
        // decrease count and sum each time accordingly
        return countSubsets(arr, n-1, sum) + countSubsets(arr, n-1, sum - arr[n-1]);
    }

    public static void main (String[] args) {

        int n = 3, arr[]= {10, 20, 15}, sum = 25;

        System.out.println(countSubsets(arr, n, sum));


    }
}
