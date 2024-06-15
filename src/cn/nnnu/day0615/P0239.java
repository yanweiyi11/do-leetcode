package cn.nnnu.day0615;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yanweiyi
 */
public class P0239 {
    public static void main(String[] args) {
        P0239 p0239 = new P0239();
        // int[] nums = {1};
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] ints = p0239.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int slideCount = nums.length - (k - 1);
        int[] result = new int[slideCount];
        int num = 0;

        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; i++) {
            myQueue.push(nums[i]);
        }
        result[num++] = myQueue.getMaxValue();

        for (int i = k; i < nums.length; i++) {
            myQueue.pop(nums[i - k]);
            myQueue.push(nums[i]);
            result[num++] = myQueue.getMaxValue();
        }
        return result;
    }

    class MyQueue {
        Deque<Integer> queue = new LinkedList<>();;

        void pop(int val) {
            if (!queue.isEmpty() && val == queue.peek()) {
                queue.poll();
            }
        }

        void push(int val) {
            while (!queue.isEmpty() && val > queue.getLast()) {
                    queue.removeLast();
            }
            queue.add(val);
        }

        int getMaxValue() {
            return queue.peek();
        }
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int slideCount = nums.length - (k - 1);
        int[] result = new int[slideCount];

        for (int i = 0; i < slideCount; i++) {
            int windowMax = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                windowMax = Math.max(nums[j], windowMax);
            }
            result[i] = windowMax;
        }
        return result;
    }
}
