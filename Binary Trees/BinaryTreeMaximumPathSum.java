// File: BinaryTreeMaximumPathSum.java

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeMaximumPathSum {

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private static int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // path passing through this node
        maxSum = Math.max(maxSum, left + right + node.val);

        // return max single path
        return node.val + Math.max(left, right);
    }

    public static void main(String[] args) {

        /*
               -10
               /  \
              9   20
                 /  \
                15   7
        */

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxPathSum(root)); // 42
    }
}