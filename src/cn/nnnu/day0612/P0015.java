package cn.nnnu.day0612;

import java.util.*;

/**
 * @author yanweiyi
 */
public class P0015 {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 1, 2};
        P0015 p0015 = new P0015();
        List<List<Integer>> lists = p0015.threeSum(nums);
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int left = i + 1, right = nums.length - 1; right > left; ) {
                int val = nums[i] + nums[left] + nums[right];
                if (val > 0) right--;
                else if (val < 0) left++;
                else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    right--;
                    left++;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum4(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            // 三元组元素a去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                // 三元组元素b去重
                if (j > i + 2 && nums[j] == nums[j - 1] && nums[j - 1] == nums[j - 2]) {
                    continue;
                }
                int c = -nums[i] - nums[j];
                if (set.contains(c)) {
                    result.add(Arrays.asList(nums[i], nums[j], c));
                    set.remove(c); // 三元组元素c去重
                } else {
                    set.add(nums[j]);
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                List<Integer> list = hashMap.get(-nums[i]);
                if (list != null && list.get(0) != i && list.get(1) != i) {
                    List<Integer> match = new ArrayList<>();
                    match.add(nums[list.get(0)]);
                    match.add(nums[list.get(1)]);
                    match.add(nums[i]);
                    Collections.sort(match);
                    set.add(match);
                }

                int key = nums[i] + nums[j];
                List<Integer> tempList = Arrays.asList(i, j);
                hashMap.put(key, tempList);
            }
        }
        return new ArrayList<>(set);
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> match = new ArrayList<>();
                        match.add(nums[i]);
                        match.add(nums[j]);
                        match.add(nums[k]);
                        Collections.sort(match);
                        set.add(match);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
