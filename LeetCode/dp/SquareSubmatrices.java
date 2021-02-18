package dp;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/18 10:51
 * @Description: 1277. 统计全为 1 的正方形子矩阵 https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/
 */
public class SquareSubmatrices {
    public int countSquares(int[][] matrix) {
        // [0,1,1,1]     [0,1,1,1]
        // [1,1,1,1] --> [1,1,2,2] --> 15
        // [0,1,1,1]     [0,1,2,3]
        // matrix[i][j] = min(matrix[i - 1][j - 1],min(matrix[i - 1][j],matrix[i][j - 1])) + 1;
        int res = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] > 0 && i > 0 && j > 0) {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
                }
                res += matrix[i][j];
            }
        }
        return res;
    }
}
