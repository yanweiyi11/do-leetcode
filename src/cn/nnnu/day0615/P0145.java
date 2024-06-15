package cn.nnnu.day0615;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author yanweiyi
 */
public class P0145 {
    public List<Integer> postorderTraversal(P0094.TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<P0094.TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            P0094.TreeNode pop = stack.pop();
            if (pop != null) {
                stack.add(pop.left);
                stack.add(pop.right);
                result.add(pop.val);
            }
        }
        Collections.reverse(result);
        return result;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        deep(root, result);
        return result;
    }

    public void deep(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        deep(root.left, result);
        deep(root.right, result);
        result.add(root.val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
