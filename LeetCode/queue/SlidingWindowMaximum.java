package queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/19 20:32
 * @Description: 239. 滑动窗口最大值 https://leetcode-cn.com/problems/sliding-window-maximum/
 * <p>
 * 1.暴力解法 i,j=i+2 双重遍历
 * 2.双端队列
 **/
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length < 0) {
            return null;
        }
        int len = nums.length, j = 0;
        int[] result = new int[len - k + 1];

        // 单调递减栈保存数组的 下标位置
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            // 删除队列中最小的元素
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);

            // 判断队首是否在窗口中
            if (i - queue.peek() >= k) {
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i >= k - 1) {
                result[j++] = nums[queue.peek()];
            }
        }
        return result;
    }
}
