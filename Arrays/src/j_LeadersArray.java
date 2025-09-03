public class j_LeadersArray {
    /*
    idea is to iterate from last and update if that is highest or not
    and print accordinglu
     */
    public void printLeaders(int arr[], int size)
    {
        int max_from_right = arr[size-1];

        /* Rightmost element is always leader */
        System.out.print(max_from_right + " ");

        for (int i = size-2; i >= 0; i--)
        {
            if (max_from_right < arr[i])
            {
                max_from_right = arr[i];
                System.out.print(max_from_right + " ");
            }
        }
    }

    /* Driver program to test above functions */
    public static void main(String[] args)
    {
        j_LeadersArray lead = new j_LeadersArray();
        int arr[] = new int[]{16, 17, 4, 3, 5, 2};
        int n = arr.length;
        lead.printLeaders(arr, n);
    }
}
