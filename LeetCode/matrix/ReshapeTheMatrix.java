package matrix;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/19 23:36
 * @Description: 566. 重塑矩阵 https://leetcode-cn.com/problems/reshape-the-matrix/description/
 **/
public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) return nums;

        int[][] reshapeNums = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                reshapeNums[i][j] = nums[index / n][index % n];
                index++;
            }
        }
        return reshapeNums;
    }
}
