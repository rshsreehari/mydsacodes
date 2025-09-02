public class f_TowerOfHanoi {
    /*
    Tower of Hanoi is a mathematical puzzle where we have three rods (A, B, and C) and N disks;
    Only one disk can be moved at a time
    a disk can only be moved if it is the uppermost disk on a stack.
    No disk may be placed on top of a smaller disk.

     */
    static void towerOfHanoi(int n, char from_rod,
                             char to_rod, char aux_rod)
    {
        if (n == 0) {
            return;
        }
        /*
        recursive pattern:
        - top n-1 discs move from A to B, Auxiliary C
        - move disc from A to C
        - transport same n-1 discs from B to C, Auxiliary A
         */
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + n + " from rod "
                + from_rod + " to rod "
                + to_rod);
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }

    // Driver code
    public static void main(String args[])
    {
        int N = 3;

        // A, B and C are names of rods
        towerOfHanoi(N, 'A', 'B', 'C');
    }
}
