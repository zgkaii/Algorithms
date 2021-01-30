package dfsbfs;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/30 21:37
 * @Description: 200. 岛屿数量 https://leetcode-cn.com/problems/number-of-islands/
 **/
public class NumberOfIslands {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    char[][] g;

    public int numIslands(char[][] grid) {
        int count = 0;
        g = grid;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                count += dfs(i, j);
            }
        }
        return count;
    }

    private int dfs(int i, int j) {
        if (i < 0 || i == g.length || j < 0 || j == g[i].length || g[i][j] == '0')
            return 0;
        // 将陆地'1'标记为'0'
        g[i][j] = '0';
        for (int k = 0; k < dx.length; k++) {
            // 访问上、下、左、右四个相邻结点
            int x = i + dx[k], y = j + dy[k];
            dfs(x, y);
        }
        return 1;
    }

    public int numIslands2(char[][] grid) {
        int islands = 0;
        g = grid;
        for (int i = 0; i < g.length; i++)
            for (int j = 0; j < g[i].length; j++)
                islands += sink(i, j);
        return islands;
    }

    int sink(int i, int j) {
        if (i < 0 || i == g.length || j < 0 || j == g[i].length || g[i][j] == '0')
            return 0;
        g[i][j] = '0';
        sink(i + 1, j);
        sink(i - 1, j);
        sink(i, j + 1);
        sink(i, j - 1);
        return 1;
    }
}
