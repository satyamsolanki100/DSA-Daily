class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode left, TreeNode right) {

        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        if (left.val != right.val) return false;

        return isMirror(left.left, right.right) &&
               isMirror(left.right, right.left);
    }
}