package dp;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/10 10:34
 * @Description: 64. 最小路径和 https://leetcode-cn.com/problems/minimum-path-sum
 * <p>
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0 && j == 0) grid[i][j] += grid[i - 1][j];
                if (i == 0 && j != 0) grid[i][j] += grid[i][j - 1];
                if (i != 0 && j != 0) grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinimumPathSum min = new MinimumPathSum();
        System.out.println(min.minPathSum(grid));
    }
}
