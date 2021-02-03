package binarysearch;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/03 16:34
 * @Description: 367. 有效的完全平方数 https://leetcode-cn.com/problems/valid-perfect-square/
 * <p>
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 16输出：True 14输出：False
 */
public class ValidPerfectSquare {
    /**
     * 二分查找
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare2(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
//        if (num == 0) return true;
//        int low = 1, high = num;
//        while (low <= high) {
//            long mid = (low + high) >>> 1;
//            if (mid * mid == num) {
//                return true;
//            } else if (mid * mid < num) {
//                low = (int) mid + 1;
//            } else {
//                high = (int) mid - 1;
//            }
//        }
//        return false;
    }

    /**
     * 1 4=1+3 9=1+3+5 16=1+3+5+7以此类推，模仿它可以使用一个while循环，
     * 不断减去一个从1开始不断增大的奇数，若最终减成了0，说明是完全平方数，否则，不是。
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare1(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}
