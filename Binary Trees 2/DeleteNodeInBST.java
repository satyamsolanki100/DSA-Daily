public class DeleteNodeInBST {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {

            // case 1: no child
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2: one child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // case 3: two children
            TreeNode successor = minValueNode(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    private static TreeNode minValueNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Test
    public static void main(String[] args) {

        /*
                5
               / \
              3   6
             / \   \
            2   4   7
        */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        root = deleteNode(root, 3);

        inorder(root);
    }

    static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}