package binarysearch;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/19 09:18
 * @Description: 300. 最长递增子序列 https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 */
public class LongestIncreasingSubsequence {
    /**
     * 动态规划 O(n2)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        // dp[i] 表示最长子序列长度
        // nums: 10 9 2 5 3 7 101 18
        // dp[i]: 1 1 1 2 2 3  4  4    --> dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; i++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 贪心 + 二分查找 n log(n)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        // nums = [4,5,6,3]
        // len = 1 => [4], [5], [6], [3]   => tails[0] = 3
        // len = 2 => [4, 5], [5, 6]       => tails[1] = 5
        // len = 3 => [4, 5, 6]            => tails[2] = 6
        // num大于tails所有元素，添加，大小+1; tails[i-1] < num <= tails[i]，则更新tails[i]
        int[] tails = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int lo = 0, hi = size;
            // 二分查找
            while (lo != hi) {
                int mid = lo + hi >>> 1;
                if (tails[mid] < num) lo = mid + 1;
                else hi = mid;
            }
            tails[lo] = num;
            if (lo == size) ++size;
        }
        return size;
    }
}
