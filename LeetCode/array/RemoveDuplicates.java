package array;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/14 20:58
 * @Description: 26. 删除排序数组中的重复项 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 在排序数组上删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。空间复杂度要求O（1）
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 **/
public class RemoveDuplicates {
    /**
     * 双指针法
     * 数组有序，重复的元素一定会相邻。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0;
        int q = 1;

        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }
}
