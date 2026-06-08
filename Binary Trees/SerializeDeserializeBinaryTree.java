import java.util.*;

public class SerializeDeserializeBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                sb.append("null,");
                continue;
            }

            sb.append(node.val).append(",");
            q.offer(node.left);
            q.offer(node.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty() && i < arr.length) {
            TreeNode node = q.poll();

            // left child
            if (!arr[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(node.left);
            }
            i++;

            // right child
            if (i < arr.length && !arr[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(node.right);
            }
            i++;
        }

        return root;
    }

    // test
    public static void main(String[] args) {

        /*
                1
               / \
              2   3
                 / \
                4   5
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String data = serialize(root);
        System.out.println("Serialized: " + data);

        TreeNode newRoot = deserialize(data);
        System.out.println("Re-Serialized: " + serialize(newRoot));
    }
}