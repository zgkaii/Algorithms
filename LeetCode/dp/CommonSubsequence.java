package dp;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/05 10:11
 * @Description: 1143. 最长公共子序列 https://leetcode-cn.com/problems/longest-common-subsequence/
 * <p>
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 */
public class CommonSubsequence {
    public int longestCommonSubsequence1(String s1, String s2) {
        // 1.创建dp[m+1][n+1] m = s1.length(), n = s2.length()
        // m/n 0 1a 2b 3c 4d 5e
        // 0
        // 1a    1  1  1  2  2
        // 2c    1  1  2  2  2
        // 3e    1  1  2  2  3
        // 2.寻找状态转移方程
        // 遍历i,j  字符不同,i退一格或者j退一格的最大值基础上加1;字符相同,直接加1
        // 状态转移方程  dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1])
        // Time: O(m * n)
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[m][n];
    }
}
