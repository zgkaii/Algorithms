package recursive;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/27 21:08
 * @Description: 226. 翻转二叉树 https://leetcode-cn.com/problems/invert-binary-tree/
 **/
public class InvertBinaryTree {
    public TreeNode3 invertTree(TreeNode3 root) {
        if (root == null) return null;
        TreeNode3 tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}
