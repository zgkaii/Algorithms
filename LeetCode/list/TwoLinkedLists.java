package list;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/22 11:09
 * @Description: 160. 相交链表　https://leetcode-cn.com/problems/intersection-of-two-linked-lists/description/
 */
public class TwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = (p1 == null) ? headB : p1.next;
            p2 = (p2 == null) ? headA : p2.next;
        }
        return p1;
    }
}
