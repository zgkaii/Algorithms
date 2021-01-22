package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/22 21:15
 * @Description: 94. 二叉树的中序遍历 https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * <p>
 * DLR--前序遍历  根 ->左 ->右
 * <p>
 * LDR--中序遍历  左 ->根 ->右
 * <p>
 * LRD--后序遍历  左 ->右 ->根
 **/
public class InOrderTraversal {
    public List<Integer> inorderTraversal1(TreeNode1 root) {
        List<Integer> list = new ArrayList<>();
        inorder(list, root);
        return list;
    }

    private void inorder(List<Integer> list, TreeNode1 root) {
        if (root == null) {
            return;
        }
        // LDR--中序遍历  左 ->根 ->右
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }

    public List<Integer> inorderTraversal2(TreeNode1 root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode1> stack = new Stack<>();
        TreeNode1 cur = root;

        while (cur != null || !stack.empty()) {
            // 找当前节点的左子节点，一直找下去，直到为空为止
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            // 出栈，这时候root就是最左子节点
            cur = stack.pop();
            list.add(cur.val);
            // 最后再访问他的右子节点
            cur = cur.right;
        }
        return list;
    }
}


class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1() {
    }

    TreeNode1(int val) {
        this.val = val;
    }

    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
