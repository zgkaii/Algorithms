package dfsbfs;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/31 00:07
 * @Description: 529. 扫雷游戏 https://leetcode-cn.com/problems/minesweeper/
 * <p>
 * 点开一个点，要么是雷，要么不是：
 * 点到 M，踩雷了，更新为X，游戏结束。
 * 点到 E，空地，分两种情况：
 * 周围 8 个格子有雷，更新为雷数。
 * 周围 8 个格子没有雷，更新为 B，并继续探测这 8 个格子。
 **/
public class Minesweeper {
    // 定义8个方向
    int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1}, dy = {0, 0, -1, 1, -1, 1, 1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        // 1.起点为雷，游戏结束
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            // 2.起点是空地,深度优先搜索周围8个格子
            dfs(board, x, y);
        }
        return board;
    }

    private void dfs(char[][] board, int i, int j) {
        // 空地 (i, j)格子有雷，递归终止，终止该路径的搜索
        int count = 0;
        for (int k = 0; k < 8; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) continue;
            if (board[x][y] == 'M') count++;
        }
        if (count > 0) {
            board[i][j] = (char) (count + '0');
            return;
        }
        // 空地(i, j)周围没有雷，将该位置修改为‘B’，向8邻域的空地继续搜索
        board[i][j] = 'B';
        for (int k = 0; k < 8; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') continue;
            dfs(board, x, y);
        }
    }
}
