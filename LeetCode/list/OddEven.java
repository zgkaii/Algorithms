package list;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/22 19:44
 * @Description: 328. 奇偶链表  https://leetcode.com/problems/odd-even-linked-list/description/
 * <p>
 * 所有的奇数节点和偶数节点分别排在一起(节点编号的奇偶性)。
 * 算法的空间复杂度应为 O(1)，时间复杂度应为 O(n)，n 为节点总数。
 **/
public class OddEven {
    public ListNode oddEvenList(ListNode head) {
        // 按奇偶分离链表，再合并链表
        // 1->2->3->4->5->null => 1->3->5  2->4->null => 1->3->5->2->4->null
        if(head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, evenHead = even;
        while(odd.next != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
