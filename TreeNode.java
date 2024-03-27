//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;


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

    public TreeNode invertTree(TreeNode root) {
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

    public void TestCase() {
        Utilities.printTree(this);
        System.out.println();
        Utilities.printTree(invertTree(this));
        System.out.println();
        Utilities.printTree(invertTree(this));
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode b = new TreeNode(8, new TreeNode(5), new TreeNode(6));
        TreeNode root = new TreeNode(1, a, b);
        root.TestCase();
    }

    public static class Utilities {
        static Queue<TreeNode> qe = new LinkedList<TreeNode>();

        public static void printTree(TreeNode root)
        {

            if(root == null) return;

            qe.add(root);
            int count = qe.size();

            while(count!=0)
            {
                System.out.print(qe.peek().val);
                System.out.print("  ");
                if(qe.peek().left!=null) qe.add(qe.peek().left);
                if(qe.peek().right!=null) qe.add(qe.peek().right);
                qe.remove(); count = count -1;
                if(count == 0 )
                {
                    System.out.println("  ");
                    count = qe.size();
                }
            }

            qe=new LinkedList<>();
        }
    }

}