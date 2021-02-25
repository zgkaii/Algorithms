package tree;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/25 20:22
 * @Description: 337. 打家劫舍 III https://leetcode-cn.com/problems/house-robber-iii/description/
 **/
public class HouseRobberThree {
    public int rob(TreeNode1 root) {
        if (root == null) return 0;

        int val1 = root.val;
        if (root.left != null) val1 += rob(root.left.left) + rob(root.left.right);
        if (root.right != null) val1 += rob(root.right.left) + rob(root.right.right);
        int val2 = rob(root.left) + rob(root.right);
        return Math.max(val1, val2);
    }

    public int rob2(TreeNode1 root) {
        // 当前节点偷，那么两子节点就不能选择偷;当前节点不偷，两子节点只需拿最多的钱(两个孩子节点偷不偷没关系)
        // 偷:左孩子能偷到的钱 + 右孩子能偷到的钱
        // 不偷：左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
        // int[] res = new int[2] 0 代表不偷，1 代表偷
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode1 root) {
        if (root == null) return new int[]{0, 0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}
