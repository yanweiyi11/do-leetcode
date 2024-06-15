package cn.nnnu.day0610;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanweiyi
 */
public class P0094 {
    public static void main(String[] args) {

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayList<Integer> integers = new ArrayList<>();

        List<Integer> left = inorderTraversal(root.left);
        Integer mid = root.val;
        List<Integer> right = inorderTraversal(root.right);

        if (left != null) {
            integers.addAll(left);
        }

        integers.add(mid);

        if (right != null) {
            integers.addAll(right);
        }

        return integers;
    }

    public static class TreeNode {
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
