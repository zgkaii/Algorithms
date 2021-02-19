package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/19 15:59
 * @Description: 594. 最长和谐子序列 https://leetcode-cn.com/problems/longest-harmonious-subsequence/description/
 * <p>
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        // nums = [1,3,2,2,5,2,3,7] 最长的和谐子序列是 [3,2,2,2,3] return 5
        // key = nums[i] value = 1,2,3
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
//            else map.put(nums[i], 1);
//        }
//
//        int max = 0;
//        for (int key : map.keySet()) {
//            if (map.containsKey(key + 1)) max = Math.max(max, map.get(key) + map.get(key + 1));
//        }
//        return max;
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) res = Math.max(res, map.get(key) + map.get(key + 1));
        }
        return res;
    }
}
