import java.util.*;

public class BinaryTreeRootToLeafPaths {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> getPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, path, result);
        return result;
    }

    private static void dfs(TreeNode node, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        path.add(node.val);

        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));
        } else {
            dfs(node.left, path, result);
            dfs(node.right, path, result);
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        /*
            Input: [1, 2, 3, 4, null, 5, 6, null, 7]
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.right = new TreeNode(7);

        List<List<Integer>> paths = getPaths(root);
        System.out.println(paths);
    }
}