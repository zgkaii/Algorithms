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
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        //用二维char数组初始化棋盘
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(0, board);
        return res;
    }

    public void backtrack(int row, char[][] board) {
        if (board.length == row) {
            res.add(charArraysToList(board));
            return;
        }
        int n = board[row].length - 1;
        for (int col = 0; col <= n; col++) {
            //排除不合法的选项
            if (!isValid(board, row, col))
                continue;
            //做选择
            board[row][col] = 'Q';
            //进入下一行决策
            backtrack(row + 1, board);
            //撤销选择
            board[row][col] = '.';
        }

    }

    public static boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        //注意由于我们是从上往下的来一个一个排列 所以不用检查下方的棋盘
        //检查正上方有没有冲突(列冲突)
        for (int r = 0; r < n; r++) {
            if (board[r][col] == 'Q')
                return false;
        }
        //检查左上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        //检查右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < board[i].length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    public static List<String> charArraysToList(char[][] board) {
        //将char数组变成list<String>
        List<String> list = new ArrayList<>();
        for (char[] c : board) {
            String str = new String(c);
            list.add(str);
        }
        return list;
    }
}
