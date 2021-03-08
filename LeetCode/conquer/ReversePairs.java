package conquer;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/03/08 20:55
 * @Description: 剑指 Offer 51. 数组中的逆序对 https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 **/
public class ReversePairs {
    public int reversePairs1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        return reverse(nums, 0, nums.length - 1);
    }

    public int reverse(int[] nums, int left, int right) {
        if (left == right) return 0;
        int mid = left + (right - left >>> 1);
        return reverse(nums, left, mid) + reverse(nums, mid + 1, right) + merge(nums, left, mid, right);
    }

    public int merge(int[] nums, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int index = 0, p1 = left, p2 = mid + 1, res = 0;

        while (p1 <= mid && p2 <= right) {
            res += nums[p1] <= nums[p2] ? 0 : mid - p1 + 1;
            help[index++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= mid) {
            help[index++] = nums[p1++];
        }
        while (p2 <= right) {
            help[index++] = nums[p2++];
        }
        for (int i = left; i <= right; i++) {
            nums[i] = help[i - left];
        }
        return res;
    }

    public int reversePairs2(int[] nums) {
        if (nums.length < 2)
            return 0;
        int[] copy = new int[nums.length];
        return mergeSort(nums, copy, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int[] copy, int left, int right) {
        // 终止条件,子数组长度为1，停止划分
        if (left >= right)
            return 0;
        // 递归划分左子数组与右子数组
        int mid = left + right >>> 1;
        int res = mergeSort(nums, copy, left, mid) + mergeSort(nums, copy, mid + 1, right);
        //  合并阶段
        int i = left, j = mid + 1, index = left, count = 0;
        while (i <= mid && j <= right) {
            if (nums[i] > nums[j]) {
                copy[index++] = nums[j];
                count = j - mid; // 统计j->mid 之间，比nums[i]小的元素个数
                j++;
            } else {
                copy[index++] = nums[i];
                res += count;
                i++;
            }
        }
        while (i <= mid) { // 处理剩下的
            copy[index++] = nums[i];
            res += count;
            i++;
        }
        while (j <= right) { // 处理剩下的
            copy[index++] = nums[j++];
        }

        for (int k = left; k <= right; ++k) {// 从copy拷贝回nums
            nums[k] = copy[k];
        }
        return res;
    }
}
