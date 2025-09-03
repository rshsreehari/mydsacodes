public class i_LeftRotatebyK {
    //func to reverse array
    public static void reverse(int arr[], int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    /*
    this logic comes from observation
    reverse array till k-1
    reverse array from k to n-1
    reverse whole array
    this will give same result as rotate by k places to left
     */
    static void leftRotate(int arr[], int d, int n) {
        if (d == 0) return;
        /*
        this is done coz rotate more than d gives same result as
        rotating d%n
        i.e rotating 9 times and 2 times is the same for n=7
         */
        d = d % n;
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5}, n = 5, d = 2;

        System.out.println("Before Rotation");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        leftRotate(arr, d, n);

        System.out.println("\nAfter Rotation");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
