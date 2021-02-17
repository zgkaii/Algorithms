package dfsbfs;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/17 14:45
 * @Description: 980. 不同路径 III https://leetcode-cn.com/problems/unique-paths-iii/
 * <p>
 * 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。
 **/
public class UniquePathsThree {
    public int uniquePathsIII(int[][] grid) {
        int step = 1, x = 0, y = 0;
        // 遍历 获取起始位置,并统计到终点所走总步数
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) step++;
                else if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }
        return dfs(grid, x, y, step);
    }

    private int dfs(int[][] grid, int x, int y, int step) {
        // 遇到障碍/越界/已走过 直接return 0
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0) return 0;
        if (grid[x][y] == 2) return step == 0 ? 1 : 0;// step = 0表示终点到2(而不是经过),才能算一种解决方案
        grid[x][y] = -2;// 已走过空格标记为-2
        int res = 0;
        res += dfs(grid, x + 1, y, step - 1);
        res += dfs(grid, x - 1, y, step - 1);
        res += dfs(grid, x, y + 1, step - 1);
        res += dfs(grid, x, y - 1, step - 1);
        grid[x][y] = 0;// dfs遍历完该位置为起始位置的情况后，置零，以不影响后面的dfs
        return res;
    }
}
