package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/8.
 */
public class Solution56 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode index = pHead;
        ListNode pri = head;
        ListNode index2;
        while (index != null) {
            if (index.next != null && index.val == index.next.val) {
                index2 = index.next;
                int v = index.val;
                while (index2 != null && index2.val == v) {
                    index2 = index2.next;
                }
                if (index2 != null) {
                    pri.next = index2;
                    index = pri.next;
                } else {
                    pri.next = null;
                    index = pri.next;
                }
            } else {
                index = index.next;
                pri = pri.next;
            }
        }
        return head.next;
    }
}
