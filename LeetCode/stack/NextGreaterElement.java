package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/24 09:38
 * @Description: 503. 下一个更大元素 II https://leetcode.com/problems/next-greater-element-ii/description/
 * <p>
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；数字 2 找不到下一个更大的数；第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 */
public class NextGreaterElement {
    public int[] nextGreaterElements1(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N * 2; i++) {
            int num = nums[i % N];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                res[stack.pop()] = num;
            }
            if (i < N) stack.push(i % N);
        }
        return res;
    }

    public int[] nextGreaterElements2(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        process(nums, result, stack, true);
        process(nums, result, stack, false);
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }

    private void process(int[] nums, int[] result, Stack<Integer> stack, boolean push) {
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.pop()] = nums[i];
            }
            if (push) {
                stack.push(i);
            }

        }
    }
}
