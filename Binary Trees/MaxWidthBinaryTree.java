import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Pair {
    TreeNode node;
    int index;

    Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

public class MaxWidthBinaryTree {

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().index; // normalize
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair curr = queue.poll();
                int currIndex = curr.index - minIndex;

                if (i == 0) first = currIndex;
                if (i == size - 1) last = currIndex;

                if (curr.node.left != null) {
                    queue.offer(new Pair(curr.node.left, 2 * currIndex));
                }
                if (curr.node.right != null) {
                    queue.offer(new Pair(curr.node.right, 2 * currIndex + 1));
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}