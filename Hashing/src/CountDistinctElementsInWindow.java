import java.util.HashMap;
/*
this is same logic as sliding window with hashmap
add frequencies and print the size of map for every window
 */
public class CountDistinctElementsInWindow {
    public static void main (String[] args)
    {
        int arr[] = new int[]{10, 10, 5, 3, 20, 5};

        int n = arr.length;
        int k=4;
        printDistinct(arr, n, k);

    }

    static void printDistinct(int arr[], int n, int k)
    {
        HashMap<Integer, Integer> m=new HashMap<>();

        for (int i = 0; i < k; i++) {
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }

        System.out.print(m.size()+" ");

        for (int i = k; i < n; i++) {

            m.put(arr[i - k],  m.get(arr[i - k]) - 1);

            if (m.get(arr[i - k]) == 0) {
                m.remove(arr[i-k]);
            }
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);

            System.out.print(m.size()+" ");
        }
    }
}
