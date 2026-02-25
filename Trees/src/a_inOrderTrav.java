// Java program for different tree traversals
class a_inOrderTrav {
    // Root of Binary Tree
    Node root;

    a_inOrderTrav() { root = null; }

    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.key + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    // Wrappers over above recursive functions
    void printInorder() { printInorder(root); }

    // Driver code
    public static void main(String[] args)
    {
        a_inOrderTrav tree = new a_inOrderTrav();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        // Function call
        System.out.println(
                "\nInorder traversal of binary tree is ");
        tree.printInorder();
    }
}