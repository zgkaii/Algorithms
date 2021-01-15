package list;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/15 10:46
 * @Description: 24. 两两交换链表中的节点 https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 */
public class SwapNodes {
    /**
     * 方法1.奇数列、偶数列分成两个链表，再merge
     * 方法2.递归
     * 方法3.迭代
     *
     * @param head
     * @return
     */
    public ListNode3 swapPairs2(ListNode3 head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode3 newHead = head.next;
        head.next = swapPairs2(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public ListNode3 swapPairs3(ListNode3 head) {
        ListNode3 dummyHead = new ListNode3(0);
        dummyHead.next = head;
        ListNode3 temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode3 node1 = temp.next;
            ListNode3 node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }
}

class ListNode3 {
    int val;
    ListNode3 next;

    ListNode3() {
    }

    ListNode3(int val) {
        this.val = val;
    }

    ListNode3(int val, ListNode3 next) {
        this.val = val;
        this.next = next;
    }
}