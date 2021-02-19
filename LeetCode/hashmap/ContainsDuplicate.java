package hashmap;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/19 15:40
 * @Description: 217. 存在重复元素 https://leetcode-cn.com/problems/contains-duplicate/description/
 * <p>
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * 输入: [1,2,3,1]
 * 输出: true
 */
public class ContainsDuplicate {
    public boolean containsDuplicate1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }

    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
