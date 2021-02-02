package greedy;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/02 19:38
 * @Description: 55.跳跃游戏 https://leetcode-cn.com/problems/jump-game/
 **/
public class JumpGame {
    public boolean canJump(int[] nums) {
        // 贪心算法: 从最终位置先跳到上一可达位置
        // i + nums[i] >= y 则 y位置可达
        if (nums == null) return false;
        int last = nums.length - 1;
        for (int i = last; i >= 0; i--) {
            if (nums[i] + i >= last) last = i;
        }
        return last == 0;
    }
}
