package dp;

import java.util.Arrays;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/05 22:34
 * @Description: 63. 不同路径 II https://leetcode-cn.com/problems/unique-paths-ii/
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 **/
public class UniquePathsTwo {
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        // m/n  0 1 2 3             m/n  0 1 2 3
        //  0   0 0 0 0              0   1 1 1 1
        //  1   1 0 0 0      ==>     1   0 1 2 3
        //  2   0 0 1 0              2   0 1 0 3
        //  3   0 0 0 0              3   0 1 1 4
//        int m = obstacleGrid.length, n = obstacleGrid[0].length;
//        int[][] dp = new int[m + 1][n + 1];
//        dp[0][1] = 1;
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (obstacleGrid[i - 1][j - 1] == 0) {
//                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//                }
//            }
//        }
//        return dp[m][n];

        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        dp[0][1] = 1;
        for (int i = 1; i <= obstacleGrid.length; i++)
            for (int j = 1; j <= obstacleGrid[0].length; j++)
                if (obstacleGrid[i - 1][j - 1] == 0) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        return dp[obstacleGrid.length][obstacleGrid[0].length];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // ?
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        UniquePathsTwo u = new UniquePathsTwo();
        System.out.println(u.uniquePathsWithObstacles1(obstacleGrid));
    }
}
