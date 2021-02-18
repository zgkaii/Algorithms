package dp;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/18 09:51
 * @Description: 221. 最大正方形 https://leetcode-cn.com/problems/maximal-square/
 */
public class MaximalSquare {
    public int maximalSquare1(char[][] matrix) {
        // 1 1 1 0 0    1 1 1 0 0
        // 1 1 1 0 1--> 1 2 2 1 1--> 3*3 = 9
        // 1 1 1 1 1    1 2 3 2 2
        // 0 0 0 1 0    1 0 0 1 0
        // dp[i,j] = min(dp[i-1, j], dp[i-1, j-1], dp[i, j-1]) + 1
        int m = matrix.length, n = matrix[0].length, max = 0;
        if (matrix == null || m == 0 || n == 0) return 0;

        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    public int maximalSquare2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, max = 0;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
