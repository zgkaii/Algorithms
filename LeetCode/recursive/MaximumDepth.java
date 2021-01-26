package recursive;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/26 9:20
 * @Description: 104. 二叉树的最大深度 https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepth {
    public int maxDepth(TreeNode3 root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
