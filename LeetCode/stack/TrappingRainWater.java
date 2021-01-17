package stack;

import java.util.Stack;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/17 19:47
 * @Description: 42. 接雨水 https://leetcode-cn.com/problems/trapping-rain-water/
 **/
public class TrappingRainWater {
    public int trap1(int[] h) {
        // 1.暴力解法：双指针遍历(慢)
        int rain = 0, len = h.length;
        for (int i = 1; i < len - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            // 查找h[i]左边界最大值
            for (int k = i; k >= 0; k--) {
                maxLeft = Math.max(maxLeft, h[k]);
            }
            // 查找h[i]右边界最大值
            for (int j = i; j < len; j++) {
                maxRight = Math.max(maxRight, h[j]);
            }
            rain += Math.min(maxLeft, maxRight) - h[i];
        }
        return rain;
    }

    public int trap2(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        // 维护一个单独递减栈
        Stack<Integer> stack = new Stack<>();
        int rain = 0, len = height.length;
        for (int i = 0; i < len; i++) {
            // 栈顶元素小于当前元素,弹栈;大于则将当前元素压栈
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                // 有多个相同数值，只留一个
                int cur = stack.pop();
                while (!stack.isEmpty() && height[stack.peek()] == height[cur]) {
                    stack.pop();
                }
                // 计算雨水量
                if (!stack.isEmpty()) {
                    int top = stack.peek();
                    // int w = i - top - 1;
                    // int h = Math.min(height[top] - height[cur], height[i] - height[cur]);
                    rain += Math.min(height[top] - height[cur], height[i] - height[cur]) * (i - top - 1);
                }
            }
            stack.push(i);
        }
        return rain;
    }

    /**
     * 动态编程
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int res = 0, left = 1, right = height.length - 2;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        while (left <= right) {
            if (leftMax <= rightMax) {
                res += Math.max(0, leftMax - height[left]);
                leftMax = Math.max(leftMax, height[left++]);
            } else {
                res += Math.max(0, rightMax - height[right]);
                rightMax = Math.max(rightMax, height[right--]);
            }
        }
        return res;
    }
}
