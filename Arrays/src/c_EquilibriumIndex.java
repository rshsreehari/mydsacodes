public class c_EquilibriumIndex {
    // Function to find equilibrium index
    public static int eqIndex(int[] arr, int n) {
        int sum = 0;
        int leftSum = 0;

        // Step 1: Calculate total sum of array
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        // Step 2: Traverse array and check equilibrium
        for (int i = 0; i < n; i++) {
            sum -= arr[i]; // sum is now the right sum for index i

            if (sum == leftSum) {
                return i; // found equilibrium index
            }

            leftSum += arr[i]; // update left sum
        }

        return -1; // no equilibrium index found
    }

    // Driver code to test
    public static void main(String[] args) {
        int[] arr = { -7, 1, 5, 2, -4, 3, 0 };
        int n = arr.length;

        int index = eqIndex(arr, n);

        if (index != -1) {
            System.out.println("Equilibrium index found at: " + index);
        } else {
            System.out.println("No equilibrium index found.");
        }
    }
}
