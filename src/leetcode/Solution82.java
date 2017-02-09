package leetcode;

/**
 * Created by nick on 2017/1/10.
 */
public class Solution82 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode begin = new ListNode(-1);
        ListNode decidedNode = begin;
        ListNode testNode = head;
        int count = 1;
        while(testNode != null) {
            while (testNode.next != null && testNode.val == testNode.next.val) {
                count++;
                testNode = testNode.next;
            }
            if (count == 1) {
                decidedNode.next = testNode;
                decidedNode = testNode;
                testNode = testNode.next;
                decidedNode.next = null;
            } else {
                testNode = testNode.next;
            }
            count = 1;
        }
        return begin.next;
    }
}
