package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/23 20:05
 * @Description: 225. 用队列实现栈 https://leetcode-cn.com/problems/implement-stack-using-queues/description/
 **/
public class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        int cnt = queue.size();
        while (cnt-- > 1) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
