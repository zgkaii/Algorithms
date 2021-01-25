package recursive;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/25 21:37
 * @Description: 98. 验证二叉搜索树 https://leetcode-cn.com/problems/validate-binary-search-tree/
 **/
public class ValidateBinarySearchTree {
    /**
     * 递归
     *
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode3 root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode3 root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        //左子树范围的最小值是minVal，最大值是当前节点的值，也就是root的值，因为左子树的值要比当前节点小
        //右子数范围的最大值是maxVal，最小值是当前节点的值，也就是root的值，因为右子树的值要比当前节点大
        return validate(root.left, minVal, root.val) && validate(root.right, root.val, maxVal);
    }

    long pre = Long.MIN_VALUE;

    /**
     * 中序遍历递增
     *
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode3 root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST2(root.left)) {
            return false;
        }
        // 当前节点 <= pre，不满足BST
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST2(root.right);
    }
}

class TreeNode3 {
    int val;
    TreeNode3 left;
    TreeNode3 right;

    TreeNode3() {
    }

    TreeNode3(int val) {
        this.val = val;
    }

    TreeNode3(int val, TreeNode3 left, TreeNode3 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
