package leetcode;

/**
 * Created by nick on 2016/11/2.
 */
public class Q_2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Solution s = new Solution();
        ListNode l3 = s.addTwoNumbers(l1, l2);
        //System.out.println(l3.val);
        while (l3.next != null) {
            l3 = l3.next;
            //System.out.println(l3.val);
        }
    }
}

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jin = 0;
        int sum;
        ListNode l1x = l1;
        ListNode l2x = l2;
        ListNode l3 = new ListNode(-1);
        ListNode l3x = l3;
        while (l1x != null || l2x != null) {
            if (l1x != null) {
                if (l2x != null) {
                    sum = l1x.val + l2x.val + jin;
                    l1x = l1x.next;
                    l2x = l2x.next;
                } else {
                    sum = l1x.val + jin;
                    l1x = l1x.next;
                }
            } else {
                sum = l2x.val + jin;
                l2x = l2x.next;
            }
            jin = 0;
            if (sum > 9) {
                jin = 1;
                sum = sum - 10;
            }
            l3x.next = new ListNode(sum);
            l3x = l3x.next;
        }
        if (jin == 1) {
            l3x.next = new ListNode(1);
        }
        return l3.next;
    }
}
