package list;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/22 16:37
 * @Description: 234. 回文链表 https://leetcode.com/problems/palindrome-linked-list/
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 */
public class PalindromeLinkedList {
    public boolean isPalindrome1(ListNode head) {
        // 快慢指针
        // 链表分为两部分=>翻转后半部分=>比较两部分是否相等=>恢复链表=>返回结果
        // 1 ->2->2->1->null => 1->2->2->1->null => 1->2  null<-2<-1  (奇数节点)
        // s/f                        s     f       h              s

        // 1 ->2->3->2->1->null => 1->2->3->2->1->null => 1->2 3<-2<-1 (偶数节点)
        // s/f                           s        f       h          s
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) slow = slow.next;// 偶数节点，让 slow 指向下一个节点
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * 改进
     */
    public boolean isPalindrome2(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) slow = slow.next;

        slow = reverse(slow);
        while (slow != null && head.val == slow.val) {
            head = head.next;
            slow = slow.next;
        }
        return slow == null;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
