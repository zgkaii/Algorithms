package greedy;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/02 19:26
 * @Description: 122. 买卖股票的最佳时机 II https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 **/
public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        // 贪心算法 只要后一天比前一天大，前一天买入后一天抛出
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) total += (prices[i + 1] - prices[i]);
        }
        return total;
    }
}
