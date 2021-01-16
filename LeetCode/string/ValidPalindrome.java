package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/16 20:57
 * @Description: 125. 验证回文串 https://leetcode-cn.com/problems/valid-palindrome/
 **/
public class ValidPalindrome {
    public static boolean isPalindrome1(String s) {
//        // 1.去除非字母字符，字母全转小写
//        String str = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
//        // 2.双指针
//        int left = 0, right = str.length() - 1;
//        while (left < right) {
//            if (str.charAt(left) != str.charAt(right)) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;

        String str1 = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String str2 = new StringBuffer(str1).reverse().toString();
        return str1.equals(str2);
    }

    public boolean isPalindrome2(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left <= right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left <= right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left <= right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "abb";
        System.out.println(isPalindrome1(s));
    }
}
