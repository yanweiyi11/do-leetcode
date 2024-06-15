package cn.nnnu.day0615;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yanweiyi
 */
public class P0144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop != null) {
                stack.add(pop.right);
                stack.add(pop.left);
                result.add(pop.val);
            }
        }
        return result;
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        deep(root, result);
        return result;
    }

    public void deep(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        deep(root.left, result);
        deep(root.right, result);
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
