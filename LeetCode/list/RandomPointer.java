package list;

import java.util.HashMap;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/23 00:18
 * @Description: 138. 复制带随机指针的链表 https://leetcode.com/problems/copy-list-with-random-pointer/
 **/
public class RandomPointer {
    /**
     * HashMap，其中将旧节点作为键，将新节点作为其值。
     */
    HashMap<Node, Node> visited = new HashMap<>();

    /**
     * 时间复杂度O(n) 空间复杂度O(n)
     *
     * @param head
     * @return
     */
    public Node copyRandomList1(Node head) {
        if (head == null) return null;
        // 如果我们已经处理了当前节点，那么我们只需返回它的克隆版本。
        if (this.visited.containsKey(head)) {
            return this.visited.get(head);
        }
        // 创建一个值与旧节点相同的新节点。 （即复制节点）
        Node node = new Node(head.val, null, null);

        // 将此值保存在HashMap中。因为遍历过程中可能由于随机指针的随机性而导致循环，这里将有助于我们避免循环。
        this.visited.put(head, node);

        // 从下一个指针开始递归复制剩余的链表,然后从随机指针开始递归复制。
        // 因此我们有两个独立的递归调用,最后我们为创建的新节点更新了下一个指针和随机指针。
        node.next = this.copyRandomList1(head.next);
        node.random = this.copyRandomList1(head.random);
        return node;
    }

    public Node getClonedNode(Node node) {
        // If the node exists then
        if (node != null) {
            // Check if the node is in the visited dictionary
            if (this.visited.containsKey(node)) {
                // If its in the visited dictionary then return the new node reference from the dictionary
                return this.visited.get(node);
            } else {
                // Otherwise create a new node, add to the dictionary and return it
                this.visited.put(node, new Node(node.val, null, null));
                return this.visited.get(node);
            }
        }
        return null;
    }

    /**
     * 时间复杂度O(n) 空间复杂度O(n)
     *
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }

        Node oldNode = head;

        // Creating the new head node.
        Node newNode = new Node(oldNode.val);
        this.visited.put(oldNode, newNode);

        // Iterate on the linked list until all nodes are cloned.
        while (oldNode != null) {
            // Get the clones of the nodes referenced by random and next pointers.
            newNode.random = this.getClonedNode(oldNode.random);
            newNode.next = this.getClonedNode(oldNode.next);

            // Move one step ahead in the linked list.
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return this.visited.get(head);
    }

    /**
     * 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public Node copyRandomList3(Node head) {
        if (head == null) return null;
        //        —————————                        —————————————————————             ———————————
        //       |         |                      |                     |           |           |
        //  1 -> 2 -> 3 -> 4   => 1 -> 1‘ -> 2 -> 2’ -> 3 -> 3‘ -> 4 -> 4’ => 1' -> 2' -> 3' -> 4'
        //  |         |                |                     |                |           |
        //   —————————                  —————————————————————                  ———————————
        // 第一步：将每个拷贝节点都放在原来对应节点的旁边。
        Node iter = head, next;
        while (iter != null) {
            next = iter.next;
            Node copy = new Node(iter.val);

            iter.next = copy;
            copy.next = next;
            iter = next;
        }

        // 第二步：为拷贝节点分配随机指针。
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // 第三步：恢复原始链表,提取克隆链表。
        iter = head;
        Node pseudoHead = new Node(0);
        Node copy, copyIter = pseudoHead;

        while (iter != null) {
            next = iter.next.next;
            // 提取克隆链表
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;
            // 保存原始链表
            iter.next = next;

            iter = next;
        }
        return pseudoHead.next;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }

        public Node(int val) {
            this.val = val;
        }
    }
}

