package recursive;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/26 9:34
 * @Description: 111. 二叉树的最小深度 https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepth {
    public int minDepth(TreeNode3 root) {
        // 缺点：慢
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

//        if (root == null) return 0;
//        if (root.left == null && root.right == null) return 1;
//
//        int leftDepth = minDepth(root.left);
//        int rightDepth = minDepth(root.right);
//
//        // 左子树/右子树为空，leftDepth=0或者rightDepth=0
//        if (root.left == null || root.right == null) {
//            return leftDepth + rightDepth + 1;
//        }
//        // 左子树/右子树都不为空，返回leftDepth和rightDepth中较小值
//        return Math.min(leftDepth, rightDepth) + 1;
    }
}
