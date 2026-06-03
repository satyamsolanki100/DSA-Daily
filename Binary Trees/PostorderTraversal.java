import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class PostorderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private static void helper(TreeNode node, List<Integer> res) {
        if (node == null) return;

        helper(node.left, res);    // Left
        helper(node.right, res);   // Right
        res.add(node.val);         // Root
    }
}