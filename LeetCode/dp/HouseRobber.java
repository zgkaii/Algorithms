package dp;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/07 14:03
 * @Description: 198. 打家劫舍 https://leetcode-cn.com/problems/house-robber/
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 **/
public class HouseRobber {
    public int rob1(int[] nums) {
        // 1.分治（子问题）  0 表示不偷; 1 表示偷
        //   不偷第i个房子: f_max(i)(0) = max(f_max(i-1)(0), f_max(i-1)(1))
        //   偷第i个房子: f_max(i)(1) = f_max(i-1)(0) + nums[i]
        // 2.状态数组定义 dp[i][0,1]
        // 3.DP方程
        //   dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1])
        //   dp[i][1] = dp[i-1][0] + nums[i]
        if (nums.length == 0 || nums == null) return 0;
        int len = nums.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 0; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }

    public int rob2(int[] nums) {
        // 1.分治（子问题） f_max(i) = max(f_max(i-2)+f(i), f_max(i-1))
        // 2.状态数组定义 dp[i]
        // 3.DP方程 dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1])
        if (nums.length == 0 || nums == null) return 0;
        int len = nums.length;
        if (len == 1) return nums[0];
        int[] dp = new int[len];
        // 虑到每间房屋的最高总金额只和该房屋的前两间房屋的最高总金额相关，
        // 因此可以使用滚动数组，在每个时刻只需要存储前两间房屋的最高总金额。
        int first = nums[0], second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return dp[len - 1];
    }

    public int rob3(int[] nums) {
        // 上面解法2 滚动数组的简写
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
}
