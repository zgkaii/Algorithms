package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/22 22:00
 * @Description: 144. 二叉树的前序遍历 https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * <p>
 * DLR--前序遍历  根 ->左 ->右
 * <p>
 * LDR--中序遍历  左 ->根 ->右
 * <p>
 * LRD--后序遍历  左 ->右 ->根
 **/
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode1 root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    private void preorder(TreeNode1 root, List<Integer> list) {
        if (root == null) {
            return;
        }
        // DLR--前序遍历  根 ->左 ->右
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
}