// File: AllTraversalsOnePass.java

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class Pair {
    TreeNode node;
    int state;

    Pair(TreeNode node, int state) {
        this.node = node;
        this.state = state;
    }
}

public class AllTraversalsOnePass {

    public static List<List<Integer>> getTraversals(TreeNode root) {

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        if (root == null) return Arrays.asList(in, pre, post);

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        while (!stack.isEmpty()) {

            Pair p = stack.pop();

            // State 1 → Preorder
            if (p.state == 1) {
                pre.add(p.node.val);
                p.state++;
                stack.push(p);

                if (p.node.left != null) {
                    stack.push(new Pair(p.node.left, 1));
                }
            }

            // State 2 → Inorder
            else if (p.state == 2) {
                in.add(p.node.val);
                p.state++;
                stack.push(p);

                if (p.node.right != null) {
                    stack.push(new Pair(p.node.right, 1));
                }
            }

            // State 3 → Postorder
            else {
                post.add(p.node.val);
            }
        }

        return Arrays.asList(in, pre, post);
    }

    public static void main(String[] args) {

        /*
              1
            /   \
           3     4
          / \   / \
         5   2 7   6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(6);

        List<List<Integer>> res = getTraversals(root);

        System.out.println("Inorder: " + res.get(0));
        System.out.println("Preorder: " + res.get(1));
        System.out.println("Postorder: " + res.get(2));
    }
}