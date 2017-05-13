package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/4/26.
 */
public class Solution14 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode i = head;
        int count = 0;
        while (i != null) {
            count++;
            i = i.next;
        }
        if (k > count) {
            return null;
        }
        i = head;
        int tar = count - k + 1;
        count = 1;
        while (count < tar) {
            i = i.next;
            count++;
        }
        return i;
    }
}
