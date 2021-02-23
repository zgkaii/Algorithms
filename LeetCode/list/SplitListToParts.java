package list;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/22 18:54
 * @Description: 725. 分隔链表 https://leetcode.com/problems/split-linked-list-in-parts/description/
 * <p>
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 **/
public class SplitListToParts {
    public ListNode2[] splitListToParts(ListNode2 root, int k) {
        ListNode2[] parts = new ListNode2[k];
        int len = 0;
        for (ListNode2 node = root; node != null; node = node.next)
            len++;
        int n = len / k, r = len % k; // n : minimum guaranteed part size; r : extra nodes spread to the first r parts;
        ListNode2 node = root, prev = null;
        for (int i = 0; node != null && i < k; i++, r--) {
            parts[i] = node;
            for (int j = 0; j < n + (r > 0 ? 1 : 0); j++) {
                prev = node;
                node = node.next;
            }
            prev.next = null;
        }
        return parts;
    }
}
