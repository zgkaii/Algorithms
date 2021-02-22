package list;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/22 11:14
 * @Description: 83. 删除排序链表中的重复元素 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 */
public class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
