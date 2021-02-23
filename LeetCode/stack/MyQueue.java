package stack;


import java.util.Stack;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/23 19:49
 * @Description: 232. 用栈实现队列 https://leetcode-cn.com/problems/implement-queue-using-stacks/description/
 **/
public class MyQueue {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();
    private int front;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        if (in.empty()) front = x;
        in.push(x);
    }

    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty())
                out.push(in.pop());
        }
        return out.pop();
    }

    public int peek() {
        if (out.isEmpty()) return front;
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
