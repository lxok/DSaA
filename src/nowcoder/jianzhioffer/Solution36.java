package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/2.
 */
public class Solution36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode i1 = pHead1;
        int l1 = 0;
        while (i1 != null) {
            l1++;
            i1 = i1.next;
        }
        ListNode i2 = pHead2;
        int l2 = 0;
        while (i2 != null) {
            l2++;
            i2 = i2.next;
        }
        i1 = pHead1;
        i2 = pHead2;
        if (l1 > l2) {
            int sub = l1 - l2;
            for (int i = 0; i < sub; i++) {
                i1 = i1.next;
            }
        } else if (l1 < l2) {
            int sub = l2 - l1;
            for (int i = 0; i < sub; i++) {
                i2 = i2.next;
            }
        }
        while (i1 != null) {
            if (i1 == i2) {
                return i1;
            } else {
                i1 = i1.next;
                i2 = i2.next;
            }
        }
        return null;
    }
}
