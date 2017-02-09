package leetcode;

/**
 * Created by nick on 2017/1/5.
 */
public class Solution61 {
    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode index = head;
        int length = 1;
        while (index.next != null) {
            index = index.next;
            length++;
        }
        int rotateLength = k % length;
        if (rotateLength == 0) {
            return head;
        }
        int newHeadIndex = length - rotateLength + 1;
        ListNode newHead = new ListNode(-1);
        int currentIndex = 1;
        index = head;
        while (index.next != null) {
            if (currentIndex == newHeadIndex - 1) {
                newHead = index.next;
                index.next = null;
                break;
            }
            index = index.next;
            currentIndex++;
        }
        index = newHead;
        while (index.next != null) {
            index = index.next;
        }
        index.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        Solution61 s = new Solution61();
        ListNode l1 = s.new ListNode(1);
        ListNode l2 = s.new ListNode(2);
        l1.next = l2;
        s.rotateRight(l1, 3);
    }
}
