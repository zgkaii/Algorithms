package dp;

import java.util.List;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/06 12:20
 * @Description: 120. 三角形最小路径和 https://leetcode-cn.com/problems/triangle/description/
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 **/
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 优化
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--)
            for (int j = 0; j < triangle.get(i).size(); j++)
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
        return dp[0];

        // 最小路径值 = 下一层相邻节点的较小值 + 当前节点值
        // DP方程：f[i,j] = min(f[i+1,j], f[i+1,j+1]) + f[i,j]
        // int n = triangle.size();
        // int[][] dp = new int[n + 1][n + 1];
        // // 自底向上 6,5,7知道下一层该如何选择，顶点2不能确定
        // for (int i = n - 1; i >= 0; i--)
        //     for (int j = 0; j <= i; j++)
        //         dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
        // return dp[0][0];
    }
}
