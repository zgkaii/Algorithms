package stack;

import java.util.Stack;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/23 19:10
 * @Description: 739. 每日温度 https://leetcode-cn.com/problems/daily-temperatures/description/
 **/
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) return null;

        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int cur = 0; cur < T.length; cur++) {
            while (!stack.isEmpty() && T[cur] > T[stack.peek()]) {
                int pre = stack.pop();

                System.out.println(pre);
                res[pre] = cur - pre;
            }
            stack.add(cur);
        }
        return res;
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        System.out.println(stack.peek());
    }
}
