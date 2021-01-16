package stack;

import java.util.Stack;

import static sun.swing.MenuItemLayoutHelper.max;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/16 18:04
 * @Description: 84. 柱状图中最大的矩形 https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * <p>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 **/
public class LargestRectangle {
    public int largestRectangleArea1(int[] heights) {


        return -1;
    }

    public int largestRectangleArea2(int[] heights) {
        int len = heights.length, i = 0, maxArea = 0;

        Stack<Integer> stack = new Stack<>();
        while (i < len) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - (stack.isEmpty() ? 0 : stack.peek() + 1)));
            }
            stack.push(i++);
        }

        while (!stack.isEmpty()) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (len - (stack.isEmpty() ? 0 : stack.peek() + 1)));
        }
        return maxArea;
    }
}
