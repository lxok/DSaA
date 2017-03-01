package leetcode;

/**
 * Created by nick on 2017/2/18.
 */
public class Solution92 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head.next == null || m == n) {
            return head;
        }
        ListNode start = new ListNode(-1);
        ListNode tmpHead = start;
        ListNode index = head;
        int count = 1;
        while(count < m) {
            tmpHead.next = index;
            tmpHead = tmpHead.next;
            index = index.next;
            count++;
        }
        ListNode mediumStart = new ListNode(-1);
        ListNode tmpListNode;
        ListNode nextTmpHead = index;
        while (count <= n) {
            tmpListNode = index;
            index = index.next;
            count++;
            tmpListNode.next = mediumStart.next;
            mediumStart.next = tmpListNode;
        }
        tmpHead.next = mediumStart.next;
        tmpHead = nextTmpHead;
        while (index != null) {
            tmpHead.next = index;
            tmpHead = tmpHead.next;
            index = index.next;
        }
        tmpHead.next = null;
        return start.next;
    }
}
