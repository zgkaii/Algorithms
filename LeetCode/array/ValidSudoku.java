package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/11 23:43
 * @Description: 36. 有效的数独 https://leetcode-cn.com/problems/valid-sudoku/description/
 **/
public class ValidSudoku {
    public boolean isValidSudoku1(char[][] board) {
        boolean[][] row = new boolean[9][9], col = new boolean[9][9], area = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int cur = board[i][j] - '1', idx = i / 3 * 3 + j / 3;
                // 行、列、3*3数独块中没有重复数字
                if (!row[i][cur] && !col[j][cur] && !area[idx][cur])
                    row[i][cur] = col[j][cur] = area[idx][cur] = true;
                else
                    return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i / 3 + "-" + j / 3))
                        return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        ValidSudoku v = new ValidSudoku();
        System.out.println(v.isValidSudoku1(board));
    }
}
