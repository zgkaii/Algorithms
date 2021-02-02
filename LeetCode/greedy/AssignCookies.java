package greedy;

import java.util.Arrays;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/02 19:05
 * @Description: 455. 分发饼干 https://leetcode-cn.com/problems/assign-cookies/description/
 **/
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        // 贪心算法：优先满足胃口小的孩子
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0; i < s.length && count < g.length; i++) {
            if (g[count] <= s[i]) count++;
        }
        return count;
    }
}
