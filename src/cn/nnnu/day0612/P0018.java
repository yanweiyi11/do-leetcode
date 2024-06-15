package cn.nnnu.day0612;

import java.util.*;

/**
 * @author yanweiyi
 */
public class P0018 {
    public static void main(String[] args) {
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        P0018 p0018 = new P0018();
        List<List<Integer>> lists = p0018.fourSum(nums, -294967296);
        System.out.println(lists);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (target > 0 && nums[i] > target)  return result;  // 一级剪枝
            if (i > 0 && nums[i] == nums[i - 1]) continue;  // 一级去重
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (target > 0 && nums[i] + nums[j] > target) break; // 二级剪枝
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;  // 二级去重
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    long val = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (val > target) right--;
                    else if (val < target) left++;
                    else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 三级去重
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        // -1、-2、0、0、1、2
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return result;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > 0 && nums[j] == nums[j - 1]) continue;
                List<List<Integer>> valueList = new ArrayList<>();
                List<List<Integer>> orDefault = map.getOrDefault(nums[i] + nums[j], valueList);
                orDefault.add(Arrays.asList(i, j));
                map.put(nums[i] + nums[j], orDefault);
            }
            int left = 0;
            int right = nums.length - 1;
            while (right > left) {
                int val = nums[left] + nums[right];
                List<List<Integer>> list = map.get(-val);
                if (!list.isEmpty()) {
                    for (List<Integer> integers : list) {
                        result.add(Arrays.asList(nums[integers.get(0)], nums[integers.get(1)], nums[left], nums[right]));
                    }
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    right--;
                    left++;
                } else if (val > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
