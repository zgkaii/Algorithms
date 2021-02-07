package dp;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/06 15:12
 * @Description: 152. 乘积最大子数组 https://leetcode-cn.com/problems/maximum-product-subarray/
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 **/
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        // 注意 负负为正
        // 1.分治（子问题） f(i) = max(f(i-1) * f(i), f(i))(x)
        //   当前元素为正：f_max(i) = max(f_max(i-1)*f(i), f_min(i-1)*f(i), f(i))
        //   当前元素为负：f_min(i) = min(f_max(i-1)*f(i), f_min(i-1)*f(i), f(i))
        // 2.状态数组定义 maxDP[i] minDP[i]
        // 3.DP方程
        //   maxDP[i] = Math.max(maxDP[i - 1] * nums[i], Math.max(minDP[i - 1] * nums[i], nums[i]));
        //   minDP[i] = Math.min(minDP[i - 1] * nums[i], Math.min(maxDP[i - 1] * nums[i], nums[i]));
        int maxDP = nums[0], minDP = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = maxDP, min = minDP;
            maxDP = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
            minDP = Math.min(min * nums[i], Math.min(max * nums[i], nums[i]));
            res = Math.max(res, maxDP);
        }
        return res;
    }

    public int maxProduct2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], result = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
}
