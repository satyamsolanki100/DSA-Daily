import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BurnTree {

    public static int minTime(TreeNode root, int target) {

        // Step 1: Parent Map + Find Target
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode targetNode = buildParentMap(root, parentMap, target);

        // Step 2: BFS
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(targetNode);
        visited.add(targetNode);

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burnedSomething = false;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                // left
                if (curr.left != null && !visited.contains(curr.left)) {
                    queue.offer(curr.left);
                    visited.add(curr.left);
                    burnedSomething = true;
                }

                // right
                if (curr.right != null && !visited.contains(curr.right)) {
                    queue.offer(curr.right);
                    visited.add(curr.right);
                    burnedSomething = true;
                }

                // parent
                if (parentMap.get(curr) != null && !visited.contains(parentMap.get(curr))) {
                    queue.offer(parentMap.get(curr));
                    visited.add(parentMap.get(curr));
                    burnedSomething = true;
                }
            }

            // Only increase time if fire spreads
            if (burnedSomething) time++;
        }

        return time;
    }

    // Build parent map + find target node
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
}