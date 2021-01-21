package hashmap;

import java.util.*;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/21 11:10
 * @Description: 49. 字母异位词分组 https://leetcode-cn.com/problems/group-anagrams/
 * <p>
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class GroupAnagrams {
    /**
     * 计数
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            // 统计字符串中每个字符出现的次数,作为哈希表的键。
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String key = String.valueOf(ca);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 排序
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    // 返回 str 排序后的结果。
                    // 按排序后的结果来grouping by，算子类似于 sql 里的 group by。
                    char[] array = str.toCharArray();
                    Arrays.sort(array);
                    return new String(array);
                })).values());
    }
}