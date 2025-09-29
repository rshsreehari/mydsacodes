import java.util.HashMap;
import java.util.Map;
/*
counting and checking by hashmap is fine but makes TC more worse for large inputs
thus we do another approach to make TC O(nk)
 */
public class MoreThanNbyKOccur {
    public static void main(String[] args) {
        int arr[] = new int[]{30, 10, 20, 20, 20, 10, 40, 30, 30};

        int n = arr.length;
        int k = 4;
        printNByK(arr, n, k);

    }

    static void printNByK(int arr[], int n, int k) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            if (m.containsKey(arr[i])) {
                int count = m.get(arr[i]);
                m.put(arr[i], count + 1);
            } else if (m.size() < k - 1)
                m.put(arr[i], 1);
            else
                for (Map.Entry x : m.entrySet()) {
                    Integer c = (Integer) x.getValue();
                    m.put((Integer) x.getKey(), c - 1);
                    if ((Integer) x.getKey() == 0)
                        m.remove(x.getKey());
                }
        }
        for (Map.Entry x : m.entrySet()) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if ((Integer) x.getKey() == arr[i])
                    count++;

            }
            if (count > n / k)
                System.out.print(x.getKey() + " ");
        }

    }
}
