class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class ChildrenSumProperty {

    public static boolean isSumProperty(TreeNode root) {
        // Base case
        if (root == null) return true;

        // Leaf node
        if (root.left == null && root.right == null) return true;

        int leftVal = (root.left != null) ? root.left.val : 0;
        int rightVal = (root.right != null) ? root.right.val : 0;

        // Check current node + recurse
        return (root.val == leftVal + rightVal) &&
               isSumProperty(root.left) &&
               isSumProperty(root.right);
    }
}