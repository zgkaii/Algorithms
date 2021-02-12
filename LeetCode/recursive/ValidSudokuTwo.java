package recursive;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/12 21:28
 * @Description: 37. 解数独 https://leetcode-cn.com/problems/sudoku-solver/
 **/
public class ValidSudokuTwo {
    public void solveSudoku1(char[][] board) {
        if (board == null || board.length == 0) return;
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char c = '1'; c <= '9'; c++) {
                    if (isValid(board, i, j, c)) {// 判断传入数字是否合规
                        board[i][j] = c;
                        if (solve(board))
                            return true;
                        board[i][j] = '.';// 撤销选择，回溯
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;// check 列
            if (board[row][i] == c) return false;// check 行
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;// check 3*3 块
        }
        return true;
    }
}
