package conquer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/03/07 22:38
 * @Description: 241. 为运算表达式设计优先级 https://leetcode-cn.com/problems/different-ways-to-add-parentheses
 * <p>
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * (2*((3-4)*5)) = -10
 * ((2*(3-4))*5) = -10
 * ((2*3)-(4*5)) = -14
 * (((2*3)-4)*5) = 10
 **/
public class DiffWaysToCompute {
    Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)) return map.get(input);
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '-' || ch == '*' || ch == '+') {
                // 分解子问题 （1）2*3-4与5（2）2*3与4*5（3）2与3-4*5
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                // 进一步分解子问题，直到不能分解 （1.1）2*3与4 （1.2）2与3-4 ...
                List<Integer> leftPart = diffWaysToCompute(part1);
                List<Integer> rightPart = diffWaysToCompute(part2);
                // 组合计算
                for (Integer l : leftPart) {
                    for (Integer r : rightPart) {
                        if (ch == '+')
                            res.add(l + r);
                        if (ch == '-')
                            res.add(l - r);
                        if (ch == '*')
                            res.add(l * r);
                    }
                }
            }
        }
        if (res.isEmpty()) res.add(Integer.valueOf(input));
        map.put(input, res); // 添加映射以减少进行重复计算的时间
        return res;
    }
}
