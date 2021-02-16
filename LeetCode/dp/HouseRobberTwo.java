package dp;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/16 20:14
 * @Description: 213. 打家劫舍 II https://leetcode-cn.com/problems/house-robber-ii
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 **/
public class HouseRobberTwo {
    public int rob1(int[] nums) {
        int N = nums.length;
        if (N == 0 || nums == null) return 0;
        if (N == 1) return nums[0];

        // 第一户与最后一户不能同时选择 -> max(f_max(0 -> i-1), f_max(1 -> i))
        return Math.max(robHelper(nums, 0, N - 2), robHelper(nums, 1, N - 1));
    }

    private int robHelper(int[] nums, int begin, int end) {
        // 滚动数组 每个时刻只需要存储前两间房屋的最高总金额。
        // 循环开始时，cur 表示 dp[i-1]，pre 表示 dp[i-2]
        // dp[i] = max{ dp[i-1], dp[i-2] + nums[i] }
        int pre = 0, cur = 0, tmp;
        for (int i = begin; i <= end; i++) {
            tmp = cur;
            cur = Math.max(pre + nums[i], cur);
            pre = tmp;

//            int temp = Math.max(cur, pre + i);
//            pre = cur;
//            cur = temp;
            // 循环结束时，cur表示dp[i]，pre表示 dp[i-1]
        }
        return cur;
    }
}
