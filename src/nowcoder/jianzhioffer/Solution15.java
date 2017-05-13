package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/4/26.
 */
public class Solution15 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pri = head;
        ListNode index = head.next;
        head.next = null;
        ListNode remain;
        while (index != null) {
            remain = index.next;
            index.next = pri;
            pri = index;
            index = remain;
        }
        return pri;
    }
}
