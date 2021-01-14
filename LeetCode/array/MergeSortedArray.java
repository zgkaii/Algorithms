package array;

import java.util.Arrays;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/14 20:25
 * @Description: 88. 合并两个有序数组 https://leetcode-cn.com/problems/merge-sorted-array/
 **/
public class MergeSortedArray {
    /**
     * copy数组，再排序
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 双指针 / 从后往前
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int len = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            // 设置指针 p1 和 p2 分别指向 nums1 和 nums2 的有数字尾部，从尾部值开始比较遍历
            // 同时设置指针 len 指向 nums1 的最末尾，每次遍历比较值大小之后，则进行填充
            nums1[len--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        // 将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为p2+1
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
