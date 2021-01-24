package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/24 21:25
 * @Description: 589. N叉树的前序遍历 https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 **/
public class NPreorderTraversal {
    public List<Integer> preorder(Node3 root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        preOrder(list, root);
        return list;
    }

    private void preOrder(List<Integer> list, Node3 root) {
        if (root == null) return;
        list.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            preOrder(list, root.children.get(i));
        }
    }

    /**
     * 写法2
     */
    List<Integer> res = new ArrayList<Integer>();

    public List<Integer> preorder2(Node3 root) {
        helper(root);
        return res;
    }

    public void helper(Node3 root) {
        if (root == null) return;
        res.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            helper(root.children.get(i));
        }
    }
}
