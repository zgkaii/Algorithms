package dp;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/13 20:38
 * @Description: 70.爬楼梯 https://leetcode.com/problems/climbing-stairs/
 **/
public class ClimbingStairs {
    /**
     * 分析：Fibonacci数列
     * n = 0  1  0;
     * n = 1  1  1;
     * n = 2  2  1+1; 2;
     * n = 3  3  1+1+1; 1+2; 2+1;
     * n = 4  5  1+1+1+1; 2+2; 1+2+1; 2+1+1; 1+1+2;
     * ... ...
     * f(2) = f(1) + f(0)
     * f(3) = f(2) + f(1)
     * ... ...
     * f(n) = f(n-1) + f(n-2)
     *
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        int[] step = new int[n + 1];
        step[0] = 1;
        step[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 状态转移方程
            step[i] = step[i - 1] + step[i - 2];
        }
        return step[n];
    }
}
