package leetcode;

/**
 * Created by nick on 2017/1/15.
 */
/**
 * 主要要保证最终结果的链的最后一个节点的next是空值，
 * 即greater的最后节点一点要置next为空，否则可能造成结果中存在环。
 */
public class Solution86 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode smaller = new ListNode(-1);
        ListNode smallerTest = smaller;
        ListNode greater = new ListNode(-1);
        ListNode greaterTest = greater;
        ListNode TestNode = head;
        while (TestNode != null) {
            if (TestNode.val < x) {
                smallerTest.next = TestNode;
                smallerTest = smallerTest.next;
            } else {
                greaterTest.next = TestNode;
                greaterTest = greaterTest.next;
            }
            TestNode = TestNode.next;
        }
        greaterTest.next = null;
        if (smaller.next == null) {
            return greater.next;
        }
        smallerTest.next = greater.next;
        return smaller.next;
    }

    public static void main(String[] args) {
        Solution86 s = new Solution86();
        ListNode l1 = s.new ListNode(2);
        ListNode l2 = s.new ListNode(1);
        l1.next = l2;
        System.out.println(s.partition(l1, 2).val);
    }
}
