package leetcode;

/**
 * Created by nick on 2016/12/18.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode start = new ListNode(-1);
        start.next = head;
        ListNode index = head;
        ListNode pp = start;
        ListNode from = head;
        ListNode to;
        int i = 0;
        while (index != null) {
            i++;
            if (i == 1) {
                from = index;
            }
            if (i >= k) {
                to = index;
                swap(pp, from, to);
                i = 0;
                index = from;
                pp = from;
            }
            index = index.next;
        }
        return start.next;
    }

    public void swap(ListNode pp, ListNode from, ListNode to) {
        ListNode np = from;
        ListNode n = from.next;
        ListNode nn = n.next;
        while (n != to) {
            n.next = np;
            np = n;
            n = nn;
            nn = n.next;
        }
        ListNode remain = to.next;
        n.next = np;
        pp.next = to;
        from.next = remain;
    }
}
