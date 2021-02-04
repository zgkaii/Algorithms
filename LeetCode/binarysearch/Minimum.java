package binarysearch;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/04 20:38
 * @Description: 153. 寻找旋转排序数组中的最小值 https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 **/
public class Minimum {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int lo = 0, hi = nums.length - 1;
        if (nums[hi] > nums[0]) return nums[0];
        while (lo <= hi) {
            int mid = lo + (hi - lo >>> 1);

            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid - 1] > nums[mid]) return nums[mid];

            if (nums[mid] > nums[0]) {
                // 2,3,4,5,6,7,0,1  mid左段有序 变化点在右
                lo = mid + 1;
            } else {
                // 6,7,0,1,2,3,4,5  mid右段有序 变化点在左
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 1};
        Minimum minimum = new Minimum();
        System.out.println(minimum.findMin(nums));

//        int i = 3, j = 4;
//        int k = i + (j - i) >>> 1;
//        System.out.println(k);
    }
}
