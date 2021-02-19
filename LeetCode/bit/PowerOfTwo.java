package bit;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/19 10:32
 * @Description: 231. 2的幂 https://leetcode-cn.com/problems/power-of-two/
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return (n & (n-1)) == 0;
    }
}
