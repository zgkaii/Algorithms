package recursive;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/12 21:28
 * @Description: 37. 解数独 https://leetcode-cn.com/problems/sudoku-solver/
 **/
public class ValidSudokuTwo {
    public void solveSudoku1(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        for (int i = row; i < 9; i++) {
            for (int j = col; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char num = '1'; num <= '9'; num++) {
                    if (isValid(board, i, j, num)) {// 判断传入数字是否合规
                        board[i][j] = num;
                        if (solve(board, i, j + 1)) return true;
                        board[i][j] = '.';// 撤销选择，回溯
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        int cRow = 3 * (row / 3), cCol = 3 * (col / 3);
        for (int i = 0; i < 9; i++)
            // 判断行，列，3*3代码块中存在重复数字 return false
            if (board[i][col] == num || board[row][i] == num || board[cRow + i / 3][cCol + i % 3] == num)
                return false;
        return true;
    }
}
