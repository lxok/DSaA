package leetcode;

/**
 * Created by nick on 2016/12/14.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(-1);
        ListNode index = start;
        ListNode in1 = l1;
        ListNode in2 = l2;
        while(in1 != null && in2 != null) {
            if (in1.val <= in2.val) {
                index.next = in1;
                in1 = in1.next;
            } else {
                index.next = in2;
                in2 = in2.next;
            }
            index = index.next;
        }
        if (in1 == null) {
            index.next = in2;
        } else if (in2 == null) {
            index.next = in1;
        }
        return start.next;
    }
}