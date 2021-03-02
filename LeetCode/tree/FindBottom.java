package tree;

import queue.Queue;

import java.util.LinkedList;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/03/02 19:59
 * @Description: 513. 找树左下角的值 https://leetcode-cn.com/problems/find-bottom-left-tree-value/description/
 * <p>
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 **/
public class FindBottom {
    public int findBottomLeftValue(TreeNode1 root) {
        //        1
        //       / \
        //      2   3
        //         / \
        //        5   6  => 5
        if (root.left == null && root.right == null) return root.val;

        // 广度优先遍历
        LinkedList<TreeNode1> queue = new LinkedList<>();
        queue.add(root);

        TreeNode1 tmp = new TreeNode1(-100);

        while (!queue.isEmpty()) {
            tmp = queue.poll();
            if (tmp.right != null) queue.add(tmp.right);
            if (tmp.left != null) queue.add(tmp.left);
        }
        return tmp.val;
    }
}
