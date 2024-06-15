package cn.nnnu.day0610;

import java.util.Arrays;

/**
 * @author yanweiyi
 */
public class P0977 {
    public static void main(String[] args) {
        int[] arr = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares(arr)));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int k = nums.length - 1;
        for (int left = 0, right = nums.length - 1; left <= right; ) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[k] = nums[left] * nums[left];
                k--;
                left++;
            } else {
                result[k] = nums[right] * nums[right];
                k--;
                right--;
            }
        }
        return result;
    }

    public static int[] sortedSquares2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
