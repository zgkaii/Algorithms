package hashmap;

import java.util.*;
import java.util.HashMap;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/19 16:25
 * @Description: 128. 最长连续序列 https://leetcode-cn.com/problems/longest-consecutive-sequence/description/
 * <p>
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * nums = [100,4,200,1,3,2] --> 4
 * nums = [0,3,7,2,5,8,4,6,0,1] --> 9
 * <p>
 * 你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int max = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                max = Math.max(max, currentStreak);
            }
        }
        return max;
    }


    public int longestConsecutive2(int[] nums) {
        // 1.排序 [0,3,7,2,5,8,4,6,0,1] => [0,0,1,2,3,4,5,6,7,8]
        Arrays.sort(nums);
        // 2.放入HashMap 0:2 1:1 2:1...
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 3.找出数字连续的最长序列
        int max = 0;
        for (int num : map.keySet()) {
            int curNum = 0, count = 0;
            if (!map.containsKey(num + 1)) {
                curNum = num + 1;
                max = 1;
            } else {
                curNum++;
                max += 1;
                max = Math.max(max, max);
            }
        }
        return max;
    }
}
