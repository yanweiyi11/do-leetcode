package cn.nnnu.day0610;

import java.util.Arrays;

/**
 * @author yanweiyi
 */
public class P0027 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3};
        System.out.println(removeElement(arr, 3));
        System.out.println(Arrays.toString(arr));
    }

    public static int removeElement(int[] nums, int val) {
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public static int removeElement2(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while (left <= right) {
            if (nums[right] == val) {
                right--;
                continue;
            }
            if (nums[left] == val) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                right--;
                left++;
                count++;
                continue;
            }
            left++;
            count++;
        }
        return count;
    }
}
