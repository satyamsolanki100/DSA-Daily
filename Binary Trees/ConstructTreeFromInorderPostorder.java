import java.util.*;

public class ConstructTreeFromInorderPostorder {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int postIndex;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length - 1;

        // store inorder indices
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(postorder, 0, inorder.length - 1);
    }

    private static TreeNode helper(int[] postorder, int inStart, int inEnd) {

        if (inStart > inEnd) return null;

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = map.get(rootVal);

        // IMPORTANT: build right first
        root.right = helper(postorder, inIndex + 1, inEnd);
        root.left = helper(postorder, inStart, inIndex - 1);

        return root;
    }

    // optional: preorder print to verify
    public static void printPreorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void main(String[] args) {

        int[] inorder   = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = buildTree(inorder, postorder);

        printPreorder(root); // should match preorder: 3 9 20 15 7
    }
}