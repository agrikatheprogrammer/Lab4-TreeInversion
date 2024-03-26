//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {

        this.val = val;

        this.left = left;

        this.right = right;

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