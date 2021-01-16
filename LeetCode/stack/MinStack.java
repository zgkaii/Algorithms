package stack;

import java.util.Stack;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/16 17:11
 * @Description: 155. 最小栈 https://leetcode-cn.com/problems/min-stack/
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 **/
public class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
//    private Stack<Integer> stack;
//    private Stack<Integer> min_stack;
//    public MinStack() {
//        stack = new Stack<>();
//        min_stack = new Stack<>();
//    }
//    public void push(int x) {
//        stack.push(x);
//        if(min_stack.isEmpty() || x <= min_stack.peek())
//            min_stack.push(x);
//    }
//    public void pop() {
//        if(stack.pop().equals(min_stack.peek()))
//            min_stack.pop();
//    }
//    public int top() {
//        return stack.peek();
//    }
//    public int getMin() {
//        return min_stack.peek();
//    }
}
