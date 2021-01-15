package list;

import java.util.List;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/15 10:59
 * @Description: 25. K 个一组翻转链表 https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * <p>
 * 一个链表，每 k 个节点一组进行翻转，返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么将最后剩余的节点保持原有顺序。
 * <p>
 * 示例：
 * 链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 */
public class ReverseNodesKGroup {
    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        // 1.声明一个哑节点dummy
        dummy.next = head;
        // 2.pre和end指向同一个前驱节点上
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            // 3.获取翻转链表片段 start -> ... -> end
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;
            ListNode next = end.next;
            // 孤立需翻转链表片段
            end.next = null;
            ListNode start = pre.next;
            // 4.翻转链表 dummy -> end -> ... -> start
            pre.next = reverse(pre);
            // 5.连接翻转后链表，pre和end指向同一个前驱节点上
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    // 双指针翻转链表
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * 递归
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup2(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }
}
