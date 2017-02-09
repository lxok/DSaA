package leetcode;

import java.util.List;

/**
 * Created by nick on 2017/1/11.
 */
public class Solution83 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode decidedNode = new ListNode(-1);
        ListNode beginNode = decidedNode;
        ListNode testNode = head;
        while (testNode != null) {
            while (testNode.next != null && testNode.val == testNode.next.val) {
                testNode = testNode.next;
            }
            decidedNode.next = testNode;
            decidedNode = testNode;
            testNode = testNode.next;
        }
        return beginNode.next;
    }

    public static void main(String[] args) {
        Solution83 s = new Solution83();
        ListNode l1 = s.new ListNode(1);
        ListNode l2 = s.new ListNode(1);
        l1.next = l2;
        s.deleteDuplicates(l1);
    }
}
