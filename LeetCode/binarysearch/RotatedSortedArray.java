package binarysearch;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/03 18:23
 * @Description: 33. 搜索旋转排序数组 https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 **/
public class RotatedSortedArray {

    /**
     * 二分查找 O(log n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo == hi && nums[lo] == target ? lo : -1;
    }

    public int search3(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) return mid;
            // 2,3,4,5,6,7,0,1  mid左段有序
            if (nums[mid] >= nums[lo]) {
                if (target >= nums[lo] && target < nums[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            } else {
                // 6,7,0,1,2,3,4,5  mid右段有序
                if (target > nums[mid] && target <= nums[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }
        return -1;
    }


    /**
     * 暴力解法 O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        boolean A = true;
        boolean B = true;
        System.out.println(A ^ B);
    }
}
