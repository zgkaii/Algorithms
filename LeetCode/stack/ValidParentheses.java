package stack;

import java.util.Stack;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/16 16:10
 * @Description: 20. 有效的括号 https://leetcode-cn.com/problems/valid-parentheses/
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 输入: "([)]"
 * 输出: false
 **/
public class ValidParentheses {
    /**
     * 1.暴力：不断replace匹配的括号 -> "" -> if s = "" return true
     * 2.栈：将每个字符压入栈，每个字符会与栈顶元素匹配，匹配则抵消成空 -> 栈为空 return true
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
