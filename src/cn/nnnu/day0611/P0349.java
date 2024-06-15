package cn.nnnu.day0611;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yanweiyi
 */
public class P0349 {
    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        int[] ints = new int[1005];
        Set<Integer> result = new HashSet<>();
        for (int num : nums1) {
            ints[num] = 1;
        }
        for (int num : nums2) {
            if (ints[num] == 1) {
                result.add(num);
            }
        }
        int[] array = new int[result.size()];
        int i = 0;
        for (Integer val : result) {
            array[i++] = val;
        }
        return array;
    }

    public int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int k : nums1) {
            for (int c : nums2) {
                if (set.contains(c)) {
                    continue;
                }
                if (k == c) {
                    set.add(k);
                    break;
                }
            }
        }
        int[] array = new int[set.size()];
        int i = 0;
        for (Integer val : set) {
            array[i++] = val;
        }
        return array;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        Set<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }
        int[] array = new int[result.size()];
        int i = 0;
        for (Integer val : result) {
            array[i++] = val;
        }
        return array;
    }
}
