package cn.nnnu.day0610;

/**
 * @author yanweiyi
 */
public class P0108 {
    public static void main(String[] args) {
        int[] arr = {-10,-3,0,5,9};
        TreeNode treeNode = sortedArrayToBST(arr);
        System.out.println(treeNode);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private static TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        TreeNode left = dfs(nums, start, mid - 1);
        TreeNode right = dfs(nums, mid + 1, end);

        root.left = left;
        root.right = right;

        return root;
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
