package cn.nnnu.day0610;

/**
 * @author yanweiyi
 */
public class P0209 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(minSubArrayLen(11, arr));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                sum -= nums[start];
                result = Math.min(result, end - start + 1);
                start++;
            }
        }
        if (result == Integer.MAX_VALUE) {
            return 0;
        }
        return result;
    }
}
