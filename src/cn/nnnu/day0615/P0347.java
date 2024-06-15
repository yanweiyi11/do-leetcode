package cn.nnnu.day0615;

import java.util.*;

/**
 * @author yanweiyi
 */
public class P0347 {
    public static void main(String[] args) {
        P0347 p0347 = new P0347();
        int[] nums = {1, 3};
        int[] ints = p0347.topKFrequent(nums, 2);
        System.out.println(Arrays.toString(ints));
    }

    public int[] topKFrequent(int[] nums, int k) {
        /**
         * 优先级队列是又大顶堆或小顶堆实现的，优先级队列就是一个披着队列外衣的堆，堆的底层是二叉树
         * 实现思路：
         * 遍历数组，将每个数字和对应的出现次数存储到 map 中
         * 之后创建一个仅维护 k 个元素的小顶堆，遍历 map，如果当前的小顶堆 size 大于 k 个时，
         * 将小顶堆的栈顶元素，也即当前小顶堆中出现次数最少的元素弹出，随后加入新的元素。
         */
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Map.Entry.comparingByValue());
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }
}
