package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/22 22:14
 * @Description: 145. 二叉树的后序遍历 https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 **/
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode1 root) {
        ArrayList<Integer> list = new ArrayList<>();
        postorder(list, root);
        return list;
    }

    private void postorder(ArrayList<Integer> list, TreeNode1 root) {
        if (root == null) {
            return;
        }
        // LRD--后序遍历  左 ->右 ->根
        postorder(list, root.left);
        postorder(list, root.right);
        list.add(root.val);
    }
}
