package cn.nnnu.day0610;

/**
 * @author yanweiyi
 */
public class P0704 {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(arr, 2));
    }

    public static int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public static int search(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (target > nums[mid]) {
            return search(nums, target, mid + 1, end);
        } else if (target < nums[mid]) {
            return search(nums, target, start, mid - 1);
        } else {
            return mid;
        }
    }
}
