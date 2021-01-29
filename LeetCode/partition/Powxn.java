package partition;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/29 10:02
 * @Description: 50. Pow(x, n) https://leetcode-cn.com/problems/powx-n/
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 */
public class Powxn {
    /**
     * 分治法的设计思想是：将一个难以直接解决的大问题，分割成一些规模较小的相同问题，以便各个击破，分而治之。
     */
    public double myPow1(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow2(double x, int n) {
        if (n == 0) return 1;
        // avoid integer overflow
        if (n < 0) return 1 / x * myPow2(1 / x, -(n + 1));
        return (n % 2 == 0) ? myPow2(x * x, n / 2) : x * myPow2(x * x, n / 2);

//        if (n == 0) return 1;
//        if (n < 0) {
//            n = -n;
//            x = 1 / x;
//        }
//        if (n == Integer.MIN_VALUE) {
//            x = x * x;
//            n = n / 2;
//        }
//        return (n % 2 == 0) ? myPow2(x * x, n / 2) : x * myPow2(x * x, n / 2);
    }
}
