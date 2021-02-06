package dp;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/06 13:48
 * @Description: 53. 最大子序和 https://leetcode-cn.com/problems/maximum-subarray/
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 **/
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        // 1.分治（子问题） 元素i结尾的最长子序列 max_sum[i] = max(max_sum[i-1], 0) + nums[i](从数组末尾往前看)
        //   即是说最大子序和 = max_sum[i-1] + nums[i] 或者 nums[i] (包含之前元素后最大，或者当前元素自身最大)
        // 2.状态数组定义: dp[i]
        // 3.DP方程: dp[i] = Math.max(dp[i-1] + dp[i], dp[i])
//        if (nums.length == 0) return 0;
//        int[] dp = nums;
//        int max = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = Math.max(dp[i], dp[i] + dp[i - 1]);
//            max = Math.max(max, dp[i]);
//        }
//        return max;

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
