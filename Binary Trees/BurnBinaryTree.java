import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BurnBinaryTree {

    public static int minTime(TreeNode root, int target) {

        // Step 1: Build parent map + find target node
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode targetNode = buildParentMap(root, parentMap, target);

        // Step 2: BFS from target
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(targetNode);
        visited.add(targetNode);

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean spread = false;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                // Left child
                if (curr.left != null && !visited.contains(curr.left)) {
                    queue.offer(curr.left);
                    visited.add(curr.left);
                    spread = true;
                }

                // Right child
                if (curr.right != null && !visited.contains(curr.right)) {
                    queue.offer(curr.right);
                    visited.add(curr.right);
                    spread = true;
                }

                // Parent
                if (parentMap.get(curr) != null && !visited.contains(parentMap.get(curr))) {
                    queue.offer(parentMap.get(curr));
                    visited.add(parentMap.get(curr));
                    spread = true;
                }
            }

            if (spread) time++;
        }

        return time;
    }

    // Helper: Build parent map + find target node
    private static TreeNode buildParentMap(TreeNode root,
                                           Map<TreeNode, TreeNode> parentMap,
                                           int target) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode targetNode = null;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr.val == target) {
                targetNode = curr;
            }

            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                queue.offer(curr.left);
            }

            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }

        return targetNode;
    }

    // Test
    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \ / \
            6  5 8  4
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(4);

        int target = 4;

        System.out.println(minTime(root, target)); // Output: 4
    }
}