package dp;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/13 22:21
 * @Description: 91. 解码方法 https://leetcode-cn.com/problems/decode-ways/
 **/
public class DecodeWays {
    public int numDecodings1(String s) {
        // ‘A’ - 'Z' 对应数字 1 - 26  0没有对应的字母
        // dp[i]对应新增第i位数字
        // 1.i与i-1位能组成10-26
        //   i与i-1位能组成10/20       dp[i] = dp[i-2]
        //   i与i-1位能组成11-19/21-26 dp[i] = dp[i-1] + dp[i-2]
        // 2.i与i-1位不能组成10-26
        //   i=0     return 0
        //   i=(1,9) dp[i] = dp[i-1]
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) < '7') {
                if (s.charAt(i) == '0') dp[i + 1] = dp[i - 1];
                else dp[i + 1] = dp[i] + dp[i - 1];
            } else if (s.charAt(i) == '0') {
                return 0;
            } else {
                dp[i + 1] = dp[i];
            }
        }
        return dp[s.length()];
    }

    public int numDecodings2(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n + 1];
        memo[n] = 1;
        memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];
        return memo[0];
    }

    public static void main(String[] args) {
        String s1 = "12", s2 = "226", s3 = "06", s4 = "27";
        DecodeWays d = new DecodeWays();
        System.out.println(d.numDecodings1(s1));// 2
        System.out.println(d.numDecodings1(s2));// 3
        System.out.println(d.numDecodings1(s3));// 0
        System.out.println(d.numDecodings1(s4));// 1
//        // &&优先级高于||
//        boolean t1 = true, t2 = false, t3 = false;
//        System.out.println(t1 || t2 && t3);
//        System.out.println(t3 && t1 || t2);
    }


}
