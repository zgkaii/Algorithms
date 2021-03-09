package recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/29 14:47
 * @Description: 51. N 皇后 https://leetcode-cn.com/problems/n-queens/
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 * <p>
 * 输入：n = 2 || n = 1 || n = 3(无解法)
 * 输出：[["Q"]]
 * <p>
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];               // 用二维char数组初始化棋盘
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<>();
        backtrack(res, board, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, char[][] board, int row) {
        if (board.length == row) {
            res.add(charArrayToList(board));            // 将char二维数组放入List中
            return;
        }
        int n = board[row].length - 1;
        for (int col = 0; col <= n; col++) {
            if (!isValid(board, row, col)) continue;    // 调用isValid(),排除不合法选项
            board[row][col] = 'Q';                      // 放置皇后
            backtrack(res, board, row + 1);        // 递归查询并放置下一个皇后
            board[row][col] = '.';                      // 撤销选择
        }
    }

    public static boolean isValid(char[][] board, int row, int col) {
        // 检查正上方冲突(列冲突)(由于是从上往下的来一个一个排列 所以不用检查下方的棋盘)
        for (int r = 0; r < board.length; r++)
            if (board[r][col] == 'Q') return false;
        // 检查左上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;
        // 检查右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < board[i].length; i--, j++)
            if (board[i][j] == 'Q') return false;
        return true;
    }

    public static List<String> charArrayToList(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] c : board) {
            String str = new String(c);
            list.add(str);
        }
        return list;
    }
}
