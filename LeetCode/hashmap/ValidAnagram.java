package hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/21 10:19
 * @Description: 242. 有效的字母异位词 https://leetcode-cn.com/problems/valid-anagram/
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 如果输入字符串包含 unicode 字符怎么办？能否调整你的解法来应对这种情况？
 */
public class ValidAnagram {
    /**
     * 排序
     */
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        Arrays.sort(s.toCharArray());
        Arrays.sort(t.toCharArray());

        return Arrays.equals(str1, str2);
    }


    /**
     * 哈希映射
     */
    public boolean isAnagram2(String s, String t) {
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) table[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) table[t.charAt(i) - 'a']--;
        for (int i : table) if (i != 0) return false;
        return true;
    }

    /**
     * Unicode
     */
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {
        char ch1 = 'a';
        char ch2 = 'c';
        System.out.println(ch2 - ch1);
    }
}
