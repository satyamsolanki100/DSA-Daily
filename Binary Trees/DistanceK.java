import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class DistanceK {

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        // Step 1: Parent Map
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParents(root, parentMap);

        // Step 2: BFS
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (distance == k) break;

            distance++;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                // Left
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    queue.offer(curr.left);
                }

                // Right
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    queue.offer(curr.right);
                }

                // Parent
                if (parentMap.get(curr) != null && !visited.contains(parentMap.get(curr))) {
                    visited.add(parentMap.get(curr));
                    queue.offer(parentMap.get(curr));
                }
            }
        }

        // Remaining nodes in queue = answer
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }

        return result;
    }

    // Helper to map parent
    private static void markParents(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                queue.offer(curr.left);
            }

            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }
    }
}