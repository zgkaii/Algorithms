# 191. 位1的个数 https://leetcode-cn.com/problems/number-of-1-bits/
class Solution:
    def hammingWeight1(self, n: int) -> int:
        # n & (n - 1) 把n中最低位1变为0
        # n = 10110100 --> n & (n-1) = 10110100 & 10110011 = 10110000
        res = 0
        while n:
            n &= (n - 1)
            res += 1
        return res

    def hammingWeight2(self, n: int) -> int:
        n = (n & (0x55555555)) + ((n >> 1) & (0x55555555))
        n = (n & (0x33333333)) + ((n >> 2) & (0x33333333))
        n = (n & (0x0f0f0f0f)) + ((n >> 4) & (0x0f0f0f0f))
        n = (n & (0x00ff00ff)) + ((n >> 8) & (0x00ff00ff))
        n = (n & (0x0000ffff)) + ((n >> 16) & (0x0000ffff))
        return n
