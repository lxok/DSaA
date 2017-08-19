package nowcoder.jianzhioffer2;

/**
 * Created by nick on 2017/7/6.
 */
public class S17 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode i = head;
        ListNode i1 = list1;
        ListNode i2 = list2;
        while (i1 != null && i2 != null) {
            if (i1.val <= i2.val) {
                i.next = i1;
                i1 = i1.next;
            } else {
                i.next = i2;
                i2 = i2.next;
            }
            i = i.next;
        }
        if (i1 == null) {
            i.next = i2;
        } else {
            i.next = i1;
        }
        return head.next;
    }
}
