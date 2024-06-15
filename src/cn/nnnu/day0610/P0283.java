package cn.nnnu.day0610;

/**
 * @author yanweiyi
 */
public class P0283 {
    public static void main(String[] args) {
        int [] ints = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(ints));
    }

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }

        }
        return ans;
    }

    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
        /* int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        } */
    }
}
