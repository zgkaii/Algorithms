package dfsbfs;

import java.util.HashSet;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/30 23:14
 * @Description: 433. 最小基因变化 https://leetcode-cn.com/problems/minimum-genetic-mutation/
 **/
public class MinimumGeneticMutation {
    int minStep = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        // start变化为end的每1步都应存在于bank中
        // start:"AACCGGTT" end:"AACCGGAA" bank:["AACCGGTA"]则返回-1
        dfs(new HashSet<>(), 0, start, end, bank);
        return (minStep == Integer.MAX_VALUE) ? -1 : minStep;
    }

    private void dfs(HashSet<String> visited, int count, String cur, String end, String[] bank) {
        if (cur.equals(end)) {
            minStep = Math.min(count, minStep);
        }
        for (String str : bank) {
            int diff = 0;
            for (int i = 0; i < str.length(); i++) {
                if (cur.charAt(i) != str.charAt(i)) diff++;
                // 基因库中变化差距大于1 break
                if (diff > 1) break;
            }
            // 找到库中与当前基因相差一个碱基的就是下一步变化的基因
            if (diff == 1 && !visited.contains(str)) {
                visited.add(str);
                dfs(visited, count + 1, str, end, bank);
                visited.remove(str);
            }
        }
    }
}
