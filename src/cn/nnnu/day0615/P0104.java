package cn.nnnu.day0615;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yanweiyi
 */
public class P0104 {
    public int maxDepth(TreeNode root) {
        int deep = 0;
        if (root == null) {
            return deep;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode poll = deque.poll();
                if (poll.left != null) {
                    deque.add(poll.left);
                }
                if (poll.right != null) {
                    deque.add(poll.right);
                }
            }
            deep++;
        }
        return deep;
    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
