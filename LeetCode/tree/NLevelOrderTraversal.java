package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/24 20:37
 * @Description: 429. N 叉树的层序遍历 https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * <p>
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 **/
public class NLevelOrderTraversal {
    public List<List<Integer>> levelOrder1(Node3 root) {
        // 广度优先搜索
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Queue<Node3> queue = new LinkedList<>();
        // 根节点放入队列中,不断遍历队列
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 从队列中获取每一层节点
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node3 node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            list.add(level);
        }
        return list;
    }

    public List<List<Integer>> levelOrder2(Node3 root) {
        // 递归
        List<List<Integer>> list = new ArrayList<>();
        if (list == null) return list;
        levelTravel(list, 0, root);
        return list;
    }

    private void levelTravel(List<List<Integer>> list, int level, Node3 root) {
        if (root == null) return;
        // 匹配list size 和 tree level
        if (list.size() < level + 1) {
            list.add(new ArrayList<>());
        }
        // 加入根节点，遍历递归处理子节点
        list.get(level).add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            levelTravel(list, level + 1, root.children.get(i));
        }
    }
}

class Node3 {
    public int val;
    public List<Node3> children;

    public Node3() {
    }

    public Node3(int _val) {
        val = _val;
    }

    public Node3(int _val, List<Node3> _children) {
        val = _val;
        children = _children;
    }
};