import java.util.*;

public class KthSmallestBST {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int count = 0;
    static int result = -1;

    public static int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private static void inorder(TreeNode root, int k) {
        if (root == null) return;

        inorder(root.left, k);

        count++;
        if (count == k) {
            result = root.val;
            return;
        }

        inorder(root.right, k);
    }

    // 🔍 Test
    public static void main(String[] args) {

        /*
                5
               / \
              3   6
             / \
            2   4
           /
          1
        */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        int k = 3;
        System.out.println(kthSmallest(root, k)); // Output: 3
    }
}