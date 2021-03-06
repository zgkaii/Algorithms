package partition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/29 14:44
 * @Description: 17. 电话号码的字母组合 https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {
    List<String> res = new ArrayList<>();
    String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        // “23”为例   root
        //        /   |   \
        //      a     b     c
        //     /|\   /|\   /|\
        //    d e f d e f d e f
        if (digits == null || digits.length() == 0) {
            return res;
        }
        // 调用StringBuilder比直接String拼接快
        helper(digits, new StringBuilder(), 0);
        return res;
    }

    private void helper(String digits, StringBuilder word, int idx) {
        if (idx == digits.length()) {
            res.add(word.toString());
            return;
        }

        int pos = digits.charAt(idx) - '0';
        String str = phone[pos];// "abc"
        for (int i = 0; i < str.length(); i++) {
            // 当前层逻辑处理 依次构建首字母 a/b/c
            word.append(str.charAt(i));
            // 下一层递归调用 a->d
            helper(digits, word, idx + 1);
            // 保存首字母，方便重新构建下一层 a->e/f
            word.deleteCharAt(word.length() - 1);
        }
    }
}
