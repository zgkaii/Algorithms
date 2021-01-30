package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/23 20:12
 * @Description: 102. 二叉树的层序遍历 https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 **/
public class LevelOrderTraversal2 {
    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode1 root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        // 存放最终结果
        List<List<Integer>> list = new ArrayList<>();
        dfs(1, root, list);
        return list;
    }

    private void dfs(int index, TreeNode1 root, List<List<Integer>> list) {
        if (list.size() < index) {
            list.add(new ArrayList<Integer>());
        }
        // 将当前节点的值加入到list中，index代表当前层
        list.get(index - 1).add(root.val);
        // 递归的处理左子树，右子树，同时将层数index+1
        if (root.left != null) {
            dfs(index + 1, root.left, list);
        }
        if (root.right != null) {
            dfs(index + 1, root.right, list);
        }
    }

    /**
     * 深度优先遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode1 root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> list = new ArrayList<>();
        LinkedList<TreeNode1> queue = new LinkedList<>();
        // 将根节点放入队列中，然后不断遍历队列
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            // 将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
            // 如果节点的左/右子树不为空，也放入队列中
            for (int i = 0; i < size; ++i) {
                TreeNode1 t = queue.remove();
                tmp.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            list.add(tmp);
        }
        return list;
    }
}
