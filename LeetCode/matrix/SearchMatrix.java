package matrix;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/20 21:24
 * @Description: 240. 搜索二维矩阵 II https://leetcode-cn.com/problems/search-a-2d-matrix-ii/description/
 * <p>
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 **/
public class SearchMatrix {
    /**
     * 折现搜索 O(m + n)
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        // 从左下角开始搜索，目标值大了，row--; 目标值小了, column++。
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int row = 0, col = matrix[0].length - 1;
        while (col >= 0 && row <= matrix.length) {
            if (target == matrix[row][col]) return true;
            else if (target > matrix[row][col]) row--;
            else col++;
        }
        return false;
    }

    /**
     * 暴力解法 O(n*n)
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) return true;
            }
        }
        return false;
    }
}
