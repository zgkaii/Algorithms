package binarysearch;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/03 16:30
 * @Description: 69. x 的平方根 https://leetcode-cn.com/problems/sqrtx/
 * <p>
 * 实现 int sqrt(int x) 函数。由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 输入: 4
 * 输出: 2
 */
public class SqrtX {
    public int mySqrt(int x) {
        //  i * i <= x && (i+1)(i+1) > x
        if (x == 0) return x;
        int lf = 1, rg = x;
        while (lf <= rg) {
            int mid = lf + (rg - lf) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1))
                return mid;
            else if (mid > x / mid)
                rg = mid;
            else
                lf = mid + 1;
        }
        return lf;
    }
}