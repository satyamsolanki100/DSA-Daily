import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class InorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private static void inorder(TreeNode node, List<Integer> res) {
        if (node == null) return;

        inorder(node.left, res);   // Left
        res.add(node.val);         // Root
        inorder(node.right, res);  // Right
    }
}