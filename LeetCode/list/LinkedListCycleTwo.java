package list;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/15 10:16
 * @Description: 142. 环形链表 II https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * <p>
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class LinkedListCycleTwo {
    public ListNode2 detectCycle(ListNode2 head) {
        if (head == null || head.next == null) {
            return null;
        }
        // head到环入口 距离为A, 环入口到相遇点距离为B， 相遇点到 环入口点 距离为C , 即 环长= B + C
        // slow到相遇点= A+B； fast到相遇点= A+B+C+B= A+2B+C
        // 同一地点出发追击，那么 2*(A+B) = A+2B+C --> A = C
        // 所以 slow继续运行，从与fast的相遇点到环入口点(C)，另一个 slow2 刚好与slow在环入口点相遇(A)
        ListNode2 slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            while (slow == fast) {
                ListNode2 slow2 = head;
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
