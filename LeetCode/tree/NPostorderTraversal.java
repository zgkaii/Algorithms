package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/24 21:34
 * @Description: 590. N叉树的后序遍历 https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 **/
public class NPostorderTraversal {
    public List<Integer> postorder1(Node3 root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        postOrder(list, root);
        return list;
    }

    private void postOrder(ArrayList<Integer> list, Node3 root) {
        if (root == null) return;
        for (int i = 0; i < root.children.size(); i++) {
            postOrder(list, root.children.get(i));
        }
        list.add(root.val);
    }

    /**
     * 写法2
     */
    ArrayList<Integer> list = new ArrayList<>();

    public List<Integer> postorder2(Node3 root) {
        //如果根节点为空就直接返回list
        if (root == null) return list;
        if (root.children != null) {
            for (Node3 node : root.children) {
                //递归，将子节点作为根节点传入postorder函数遍历
                postorder2(node);
            }
        }
        //访问根节点
        list.add(root.val);
        return list;
    }
}
