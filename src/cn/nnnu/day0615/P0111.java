package cn.nnnu.day0615;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yanweiyi
 */
@SuppressWarnings("all")
public class P0111 {
    public static void main(String[] args) {
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5, null, treeNode6);
        TreeNode treeNode4 = new TreeNode(4, null, treeNode5);
        TreeNode treeNode3 = new TreeNode(3, null, treeNode4);
        TreeNode treeNode2 = new TreeNode(2, null, treeNode3);
        TreeNode treeNode1 = new TreeNode(1, null, treeNode2);

        int i = minDepth(treeNode1);
        System.out.println(i);
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int curDeep = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            curDeep++;
            while (size-- > 0) {
                TreeNode poll = deque.poll();
                if (poll.left == null && poll.right == null) {
                    return curDeep;
                }
                if (poll.left != null) {
                    deque.add(poll.left);
                }
                if (poll.right != null) {
                    deque.add(poll.right);
                }
            }
        }
        return curDeep;
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
