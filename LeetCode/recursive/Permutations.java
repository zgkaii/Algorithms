package recursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/28 9:26
 * @Description: 46. 全排列 https://leetcode-cn.com/problems/permutations/
 * <p>
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        for (int num : nums) {
            output.add(num);
        }
        backtrack(nums.length, output, res, 0);
        return res;
    }

    private void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        if (first == n) {
            res.add(new ArrayList<>(output));
        }

        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}
