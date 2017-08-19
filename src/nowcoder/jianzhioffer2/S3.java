package nowcoder.jianzhioffer2;

import java.util.ArrayList;

/**
 * Created by nick on 2017/7/4.
 */
public class S3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null) {
            return res;
        }
        ListNode pri = listNode;
        ListNode cur = pri.next;
        ListNode tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pri;
            pri = cur;
            cur = tmp;
        }
        listNode.next = null;

        ListNode index = pri;
        while (index != null) {
            res.add(index.val);
            index = index.next;
        }
        return res;
    }
}
