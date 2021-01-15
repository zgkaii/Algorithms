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
    public ListNode3 swapPairs(ListNode3 head) {
        // 1.奇数列、偶数列分成两个链表 ，再merge
        // 2.
        return null;
    }
}

class ListNode3 {
    int val;
    ListNode next;

    ListNode3() {
    }

    ListNode3(int val) {
        this.val = val;
    }

    ListNode3(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}