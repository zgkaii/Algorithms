package array;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/19 23:38
 * @Description: 485. 最大连续 1 的个数 max-consecutive-onesleetcode-cn.com/problems/max-consecutive-ones/description/
 * <p>
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 * [1,1,0,1,1,1] 3
 **/
public class MaxOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) count++;
            else count = 0;
        }
        return count;
    }

}
