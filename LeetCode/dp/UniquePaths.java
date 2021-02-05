package dp;

import java.util.Arrays;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/05 11:01
 * @Description: 62. 不同路径 https://leetcode-cn.com/problems/unique-paths/
 * <p>
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 输入：m = 3, n = 7
 * 输出：28
 * 输入：m = 3, n = 3
 * 输出：6
 */
public class UniquePaths {
    public int uniquePaths1(int m, int n) {
        // m/n 0 1 2
        //  0  1 1 1
        //  1  1 2 3
        //  2  1 3 6
        int[][] dp = new int[m][n];
        // 第一列都是1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        // 第一行都是1
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        return dp[m - 1][n - 1];
//        // 1维数组
//        int[] dp = new int[m];
//        Arrays.fill(dp, 1);
//        for (int j = 1; j < n; j++)
//            for (int i = 1; i < m; i++)
//                dp[i] += dp[i - 1];
//        return dp[m - 1];
    }
}
