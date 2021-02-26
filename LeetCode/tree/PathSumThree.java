package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/26 20:22
 * @Description: 437. 路径总和 III  https://leetcode-cn.com/problems/path-sum-iii/description/
 **/
public class PathSumThree {
    public int pathSum(TreeNode1 root, int sum) {
        // 找到从当前节点找到所有路径，再将起始节点移到该两个子节点。
        // Time O(n^2)
        if (root == null) return 0;
        return dfs(root, sum, 0) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int dfs(TreeNode1 root, int sum, int cur) {
        if (root == null) return 0;
        cur += root.val;
        return (cur == sum ? 1 : 0) + dfs(root.left, sum, cur) + dfs(root.right, sum, cur);
    }

    public int pathSum2(TreeNode1 root, int sum) {
        //      8
        //     / \
        //    5  -3
        //   / \   \
        //  3   2   6
        // 前缀和 = 该节点到根之间的路径和         5前缀和 => 1+5  3前缀和 => 1+5+3
        // 两节点间的路径和 = 两节点的前缀和之差    5、3路径和 => 3
        // 问题转换成cur（前缀和） - target 是否存在于树中
        // key:前缀和, value:节点数量
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return backtrack(root, 0, sum, map);
    }

    public int backtrack(TreeNode1 root, int sum, int target, Map<Integer, Integer> map) {
        if (root == null) return 0;
        // 当前路径上的和
        sum += root.val;
        // 看看root到当前节点这条路上是否存在节点前缀和加target为curSum的路径
        // 前节点->root节点反推，有且仅有一条路径，如果此前有和为curSum-target,而当前的和又为curSum,两者的差就肯定为target了
        // curSum-target相当于找路径的起点，起点的sum+target=curSum，当前点到起点的距离就是target
        int res = map.getOrDefault(sum - target, 0);
        // 更新路径上当前节点前缀和的个数
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        // 进入下一层
        res += backtrack(root.left, sum, target, map) + backtrack(root.right, sum, target, map);
        // 回到本层，恢复状态，去除当前节点的前缀和数量
        map.put(sum, map.get(sum) - 1);
        return res;
    }
}
