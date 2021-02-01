package dp;

import java.util.Arrays;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/01 19:43
 * @Description: 322. 零钱兑换 https://leetcode-cn.com/problems/coin-change/
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3 (5 + 5 + 1)
 **/
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // F(i) = min(F(i - Cj)) + 1 (j = 0,1,2...,n-1) Cj为最后一枚硬币值，i为金额
        // coins = [1,2], amount = 5
        // F(0) = 0, F(1) = 1
        // F(2) = min(F(2-1) + F(2-2)) + 1  1
        // F(3) = min(F(3-1) + F(3-2)) + 1  2
        // F(4) = min(F(4-1) + F(4-2)) + 1  2
        // F(5) = min(F(5-1) + F(5-2)) + 1  3
        int max = amount + 1;// 等同Integer.MAX_VALUE
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    // 状态转移方程
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
