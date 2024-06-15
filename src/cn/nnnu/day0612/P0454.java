package cn.nnnu.day0612;

import java.util.HashMap;

/**
 * @author yanweiyi
 */
public class P0454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int key = num1 + num2;
                hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
            }
        }
        int count = 0;
        for (int num3: nums3) {
            for (int num4: nums4) {
                int key = num3 + num4;
                Integer value = hashMap.get(0 - key);
                if (value != null) {
                    count += value;
                }
            }
        }
        return count;
    }
}
