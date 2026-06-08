import java.util.*;

public class BinaryTreeInorderTraversal2 {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // ✅ Recursive Approach
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private static void dfs(TreeNode node, List<Integer> res) {
        if (node == null) return;

        dfs(node.left, res);   // Left
        res.add(node.val);     // Root
        dfs(node.right, res);  // Right
    }

    // ✅ Iterative Approach (Stack)
    public static List<Integer> inorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }

        return result;
    }

    // 🔍 Test
    public static void main(String[] args) {

        /*
            Example:
                1
                 \
                  2
                 /
                3
        */

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(inorderTraversal(root));     // [1,3,2]
        System.out.println(inorderIterative(root));     // [1,3,2]
    }
}