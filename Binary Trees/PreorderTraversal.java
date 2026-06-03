import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class PreorderTraversal {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private static void preorder(TreeNode node, List<Integer> res) {
        if (node == null) return;

        res.add(node.val);          // Root
        preorder(node.left, res);   // Left
        preorder(node.right, res);  // Right
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(preorderTraversal(root)); // [1,2,3]
    }
}