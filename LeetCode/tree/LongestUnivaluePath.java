package tree;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/27 21:25
 * @Description: 687. 最长同值路径 https://leetcode-cn.com/problems/longest-univalue-path/
 **/
public class LongestUnivaluePath {
    private int res = 0;

    public int longestUnivaluePath(TreeNode1 root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode1 root) {
        //          5
        //         / \
        //        4   5         情况1: 5->5->5
        //       / \   \        情况2: 4->4->4
        //      4   4   5
        if (root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        // 情况2,经过根节点,更新leftPath+rightPath
        int leftPath = root.left != null && root.left.val == root.val ? left + 1 : 0;
        int rightPath = root.right != null && root.right.val == root.val ? right + 1 : 0;
        res = Math.max(res, leftPath + rightPath);

        return Math.max(leftPath, rightPath);
    }
}
