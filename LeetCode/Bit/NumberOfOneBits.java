package Bit;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/08 16:59
 * @Description: 191. 位1的个数 https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class NumberOfOneBits {
    public int hammingWeight1(int n) {
        int bits = 0, mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) bits++;
            mask <<= 1;
        }
        return bits;
    }

    public int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

}
