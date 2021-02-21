package array;

import java.util.Collections;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/14 21:45
 * @Description: 189. 旋转数组 https://leetcode-cn.com/problems/rotate-array/
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 **/
public class RotateArray {
    /**
     * 拷贝临时数组后重新赋值
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int[] tmp = new int[nums.length];
        System.arraycopy(nums, 0, tmp, 0, nums.length);
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = tmp[i];
        }
    }

    /**
     * 多次反转
     * 1234 -> 4321; 567->765; 4321 765 -> 567 1234
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return;
        }
        // If the step is two or more times bigger than the input array length, it equals the remainder.
        // For example, we let the input array is [1,2,3], and the step is 7, it is as same as 1.
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] nums, int i, int j) {
        int tmp = 0;
        while (i < j) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
//            nums[i++] = nums[j];
//            nums[j--] = tmp;
        }
    }
}
