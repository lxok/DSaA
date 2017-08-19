package nowcoder.jianzhioffer2;

/**
 * Created by nick on 2017/7/6.
 */
public class S16 {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pri = head;
        ListNode index = pri.next;
        ListNode tmp;
        while (index != null) {
            tmp = index.next;
            index.next = pri;
            pri = index;
            index = tmp;
        }
        head.next = null;
        return pri;
    }
}
