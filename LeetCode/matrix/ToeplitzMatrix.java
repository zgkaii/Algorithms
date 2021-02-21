package matrix;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/21 17:50
 * @Description: 766. 托普利茨矩阵 https://leetcode-cn.com/problems/toeplitz-matrix/description/
 **/
public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        // 1 2 3 4
        // 0 1 2 3
        // 2 0 1 2
        // A[0][1] = A[1][2] = A[2[3]
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i > 0 && j > 0 && matrix[i - 1][j - 1] != matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
