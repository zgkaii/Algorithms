package binarysearch;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/04 20:16
 * @Description: 74. 搜索二维矩阵 https://leetcode-cn.com/problems/search-a-2d-matrix/
 * <p>
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 **/
public class Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) j--;
            else i++;
        }
        return false;
    }
    // 1.暴力解法 双重遍历
    // 2.二分查找 row = mid / n; col = mid % m;
//        int m = matrix.length, n = matrix[0].length;
//        if (m == 0) return false;
//
//        int lo = 0, hi = m * n - 1, mid, midElement;
//        while (lo <= hi) {
//            mid = (lo + hi) >>> 1;
//            midElement = matrix[mid / n][mid % n];
//            if (target == midElement) return true;
//            else {
//                if (target < midElement) hi = mid - 1;
//                else lo = mid + 1;
//            }
//        }
//        return false;
//    }
}
