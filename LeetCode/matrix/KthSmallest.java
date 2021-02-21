package matrix;

import java.util.Arrays;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/21 17:06
 * @Description: 378. 有序矩阵中第 K 小的元素 https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 * <p>
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 * matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * 矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 **/
public class KthSmallest {
    public int kthSmallest1(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int lo = matrix[0][0], hi = matrix[m - 1][n - 1];

        while (lo <= hi) {
            int mid = lo + (hi - lo >>> 1);
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
                    cnt++;
                }
            }
            if (cnt < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo >>> 1);
            int count = getLessEqual(matrix, mid);

            if (count < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

    private int getLessEqual(int[][] matrix, int val) {
        int res = 0;
        int n = matrix.length, i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > val) i--;
            else {
                res += i + 1;
                j++;
            }
        }
        return res;
    }
}
