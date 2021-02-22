package list;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/22 15:29
 * @Description: 19. 删除链表的倒数第 N 个结点 https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class RemoveNthNode {
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        // "快慢指针"
        // 1,2,3,4,5,null  =>  1,2,3,4,5,null   n = 2
        // p     q                 p     q
        // 1,2,null  =>  1,2,null   n = 1
        // p   q         p q
        ListNode p = head, q = head;
        while (n-- > 0) q = q.next;
        if (q == null) return q.next;// ?
        while (q.next != null) {
            q = q.next;
            p = p.next;
        }
        // 1,2,3,5,null
        p.next = p.next.next;
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // s  ,1,2,3,4,5,null  =>  s,1,2,3,4,5,null  =>  s,1,2,3,4,5,null   n = 2
        // p/q     q               p     q                     p     q
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start, fast = start;

        for (int i = 1; i <= n + 1; i++) fast = fast.next;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }
}
