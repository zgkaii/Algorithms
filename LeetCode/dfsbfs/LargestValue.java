package dfsbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/30 23:38
 * @Description: 515. 在每个树行中找最大值 https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 **/
public class LargestValue {
    public List<Integer> largestValues1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // 深度优秀搜索
        dfs(list, 0, root);
        return list;
    }

    private void dfs(List<Integer> list, int level, TreeNode node) {
        if (node == null) return;
        // expand list size
        if (list.size() == level) {
            list.add(node.val);
        } else {
            //or set value
            list.set(level, Math.max(list.get(level), node.val));

        }
        dfs(list, level + 1, node.left);
        dfs(list, level + 1, node.right);
    }

    public List<Integer> largestValues2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> values = new ArrayList<Integer>();

        if (root != null) q.offer(root);
        // 广度优先搜索
        while (!q.isEmpty()) {
            int max = Integer.MIN_VALUE, n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            values.add(max);
        }
        return values;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
