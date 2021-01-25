package recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/25 20:52
 * @Description: 22. 括号生成 https://leetcode-cn.com/problems/generate-parentheses/
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 **/
public class GenerateParentheses {
    private List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        generate(0, 0, n, "");
        return result;
    }

    private void generate(int left, int right, int n, String s) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }
        // left<n 左括号随意加，right<left 右括号随意加
        if (left < n) generate(left + 1, right, n, s + "(");
        if (right < left) generate(left, right + 1, n, s + ")");
    }

    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        g.generateParenthesis(3);
    }
}
