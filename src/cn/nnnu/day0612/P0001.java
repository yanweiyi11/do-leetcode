package cn.nnnu.day0612;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author yanweiyi
 */
public class P0001 {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        // int[] arr = {3, 2, 4};
        // int[] arr = {3, 3};
        P0001 P0001 = new P0001();
        int[] ints = P0001.twoSum(arr, 9);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer match = hashMap.get(nums[i]);
            if (match != null && i != match) {
                return new int[]{i, match};
            }
            hashMap.put(target - nums[i], i);
        }
        return null;
    }
}
