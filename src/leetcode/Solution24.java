package leetcode;

/**
 * Created by nick on 2016/12/17.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution24 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        Solution24 s = new Solution24();
        ListNode res = s.swapPairs(l1);
        ListNode r = res;
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode start = new ListNode(-1);
        start.next = head;
        ListNode index = head;
        ListNode previous = head;
        ListNode pp = start;
        boolean flag = false;
        int n = 0;
        while(index != null) {
            ListNode current = index;
            if (flag) {
                swap(pp, previous, current);
                pp = previous;
                index = previous;
                flag = false;
            } else {
                previous = index;
                flag = true;
            }
            index = index.next;
        }
        if (flag) {
            pp.next = previous;
        }
        return start.next;
    }

    public void swap(ListNode pp, ListNode previous, ListNode current) {
        previous.next = current.next;
        current.next = previous;
        pp.next = current;
    }
}
