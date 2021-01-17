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
    public int largestRectangleArea1(int[] h) {
        int len = h.length, i = 0, maxArea = 0;
        // 维护一个栈
        Stack<Integer> s = new Stack<>();
        // 当找到h右 < h左时，才能确定h左的右边界
        while (i < len) {
            while (!s.isEmpty() && h[i] < h[s.peek()]) {
                // int height = h[s.pop()];
                // int width = i - (s.isEmpty() ? 0 : s.peek() + 1);
                maxArea = Math.max(maxArea, h[s.pop()] * (i - (s.isEmpty() ? 0 : s.peek() + 1)));
            }
            s.push(i++);
        }
        while (!s.isEmpty()) {
            maxArea = Math.max(maxArea, h[s.pop()] * (len - (s.isEmpty() ? 0 : s.peek() + 1)));
        }
        return maxArea;
    }
}
