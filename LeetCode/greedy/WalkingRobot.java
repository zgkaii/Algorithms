package greedy;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/02 10:54
 * @Description: 874. 模拟行走机器人 https://leetcode-cn.com/problems/walking-robot-simulation/
 */
public class WalkingRobot {
    public int robotSim(int[] commands, int[][] obstacles) {
        // -2左转,-1右转,1 <= x <= 9移动x个单位长度
        // +Y 北; +X 东; -Y 南; -X 西
        // commands = [4,-1,3], obstacles = [] 输出：25
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        

        return 0;
    }
}
