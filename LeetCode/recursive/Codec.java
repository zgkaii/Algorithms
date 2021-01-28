package recursive;

import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/28 16:59
 * @Description: 297. 二叉树的序列化与反序列化 https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * <p>
 * 设计一个算法，把二叉树转化为一个字符串，并且还能把这个字符串还原成原来的二叉树。
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 */
public class Codec {
    private static final String spliter = ",";
    private static final String NN = "x";

    // Encodes a tree to a single string.
    public String serialize(TreeNode4 root) {
        StringBuffer sb = new StringBuffer();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode4 node, StringBuffer sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode4 deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode4 buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            TreeNode4 node = new TreeNode4(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));