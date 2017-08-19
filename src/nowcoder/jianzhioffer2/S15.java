package nowcoder.jianzhioffer2;

/**
 * Created by nick on 2017/7/6.
 */
public class S15 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) {
            return null;
        }
        ListNode index = head;
        int count = 0;
        while (index != null) {
            count++;
            index = index.next;
        }
        if (k > count) {
            return null;
        }
        int t = count - k;
        index = head;
        for (int i = 0; i < t; i++) {
            index = index.next;
        }
        return index;
    }
}
