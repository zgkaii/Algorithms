package list;

import java.util.HashSet;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/15 9:41
 * @Description: 141. 环形链表 https://leetcode-cn.com/problems/linked-list-cycle/
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 */
public class LinkedListCycle {
    /**
     * 哈希表（慢）
     *
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode2 head) {
        // 1.遍历所有链表节点，每遍历一个节点，判断之前是否访问过，遍历完节点为止
        //   用哈希表来存储已访问的节点
        HashSet<ListNode2> see = new HashSet<ListNode2>();
        while (head != null) {
            if (!see.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode2 head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode2 slow = head;
        ListNode2 fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2(int x) {
        val = x;
        next = null;
    }
}