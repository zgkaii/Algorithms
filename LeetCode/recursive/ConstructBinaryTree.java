package recursive;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/27 20:15
 * @Description: 105. 从前序与中序遍历序列构造二叉树 https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 前序遍历：根-左-右
 * 中序遍历：左-根-右
 * <p>
 * 关键在于如何定位根节点
 **/
public class ConstructBinaryTree {
    private Map<Integer, Integer> indexMap;

    public TreeNode3 buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode3 build(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right) {
        if (pre_left > pre_right) return null;
        // 前序遍历第一个节点就是根节点
        int pre_root = pre_left;
        // 中序遍历定位根节点
        int in_root = indexMap.get(preorder[pre_left]);
        //preorder = [3, 9, 8, 5, 4, 10, 20, 15, 7]
        //inorder = [4, 5, 8, 10, 9, 3, 15, 20, 7]
        // 建立根节点 root = 3
        TreeNode3 root = new TreeNode3(preorder[pre_root]);
        // 左子树的节点数目 5
        int size_left = in_root - in_left;
        // 先序遍历「左边界+1 = size_left」(9, 8, 5, 4, 10)对应中序遍历「左边界 开始到 根节点定位-1」(4, 5, 8, 10, 9)
        root.left = build(preorder, inorder, pre_left + 1, pre_left + size_left, in_left, in_root - 1);
        // 先序遍历「左边界+1+左子树节点数目 开始到 右边界」(20, 15, 7)对应中序遍历「根节点定位+1 到 右边界」(15, 20, 7)
        root.right = build(preorder, inorder, pre_left + size_left + 1, pre_right, in_root + 1, in_right);
        return root;
    }
}