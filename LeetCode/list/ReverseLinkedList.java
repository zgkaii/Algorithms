package list;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/14 17:26
 * @Description: 206. 反转单链表 https://leetcode-cn.com/problems/reverse-linked-list/
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 进阶:
 * 可以迭代或递归地反转链表。
 */
public class ReverseLinkedList {
    /**
     * 双指针
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            // 每次访问的原链表节点都会成为新链表的头结点
            cur.next = pre;
            // 更新新链表
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        //从当前节点的下一个结点开始递归调用
        ListNode p = reverseList(next);
        //head挂到next节点的后面就完成了链表的反转。
        next.next = head;
        //这里head相当于变成了尾结点，尾结点都是为空的，
        //否则会构成环
        head.next = null;
        return p;
    }
}
