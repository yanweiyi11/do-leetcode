package cn.nnnu.day0610;

/**
 * @author yanweiyi
 */
public class P0136 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 1, 3};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        return x;
    }
}
