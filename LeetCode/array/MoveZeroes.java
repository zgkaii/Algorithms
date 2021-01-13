package array;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/13 21:16
 * @Description: 283.移动零 https://leetcode.com/problems/move-zeroes/
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 不能copy数组
 **/
public class MoveZeroes {
    /**
     * 非零往前挪动 其余补零
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                j++;
            }
        }
    }

    public void moveZeroes3(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
