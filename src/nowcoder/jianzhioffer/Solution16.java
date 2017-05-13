package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/4/27.
 */
public class Solution16 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode i = head;
        ListNode i1 = list1;
        ListNode i2 = list2;
        while (i1 != null && i2 != null) {
            if (i1.val <= i2.val) {
                i.next = i1;
                i = i.next;
                i1 = i1.next;
            } else {
                i.next = i2;
                i = i.next;
                i2 = i2.next;
            }
        }
        if (i1 != null) {
            i.next = i1;
        } else {
            i.next = i2;
        }
        return head.next;
    }
}
