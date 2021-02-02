package greedy;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/02 20:16
 * @Description: 45. 跳跃游戏 II https://leetcode-cn.com/problems/jump-game-ii/
 **/
public class JumpGameTwo {
    public int jump(int[] nums) {
        // 贪心算法 尽量跳最大步
        // 跳转范围[begin,end] farthest为[begin,end]最远点
        // 一旦当前点达到end，则触发另一个跳转，并将新end设置为farthest为
        int farthest = 0, step = 0, end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if (i == end) {
                step++;
                end = farthest;
            }
        }
        return step;
    }
}
