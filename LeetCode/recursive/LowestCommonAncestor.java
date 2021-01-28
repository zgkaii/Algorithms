package recursive;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/28 15:56
 * @Description: 236. 二叉树的最近公共祖先 https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。（一个节点也可以是它自己的祖先）。
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 */
public class LowestCommonAncestor {
    public TreeNode4 lowestCommonAncestor(TreeNode4 root, TreeNode4 p, TreeNode4 q) {
        if (root == null || root == p || root == q) return root;

        TreeNode4 left = lowestCommonAncestor(root.left, p, q);
        TreeNode4 right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;

//        if (left == null && right == null) return null;
//        // 节点都是右子树上
//        if (left == null) return right;
//        // 节点都是左子树上
//        if (right == null) return left;
//        if (left != null && right != null) return root;
    }
}


class TreeNode4 {
    int val;
    TreeNode4 left;
    TreeNode4 right;

    TreeNode4(int x) {
        val = x;
    }
}