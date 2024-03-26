public class TreeInversion {
    public static void main(String[] arr) {
        TreeNode a = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode b = new TreeNode(8, new TreeNode(5), new TreeNode(6));
        TreeNode root = new TreeNode(1, a, b);
        Utilities helper = new Utilities();
        helper.printTree(root);
        System.out.println();
        helper.printTree(invertTree(root));
        System.out.println();
        helper.printTree(invertTree(root));
    }
    public static TreeNode invertTree(TreeNode root) {
        if (root != null) { // if root is null, no work needed
            TreeNode temp = root.right; // swap its children
            // if either right or left or both are null,
            // still swap using three lines of boiler code, and it works
            root.right = root.left;
            root.left = temp;
            invertTree(root.right); // do the same for right child
            invertTree(root.left); // and left child
        }
            return root; // all calls return null as recursion goes on until
        // all non-null roots are swapped
        }
}


