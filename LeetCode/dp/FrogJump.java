package dp;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/14 00:30
 * @Description: 403. 青蛙过河 https://leetcode-cn.com/problems/frog-jump/
 **/
public class FrogJump {
    public boolean canCross(int[] stones) {
        // 第一步只能为1; 上一步为k,下一步只能k-1/k/k+1; 第一个石头永远在stones[0]
        if (stones[1] != 1) return false;

        return false;
    }
}
