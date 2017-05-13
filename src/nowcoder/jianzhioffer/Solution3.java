package nowcoder.jianzhioffer;

import java.util.ArrayList;

/**
 * Created by nick on 2017/4/25.
 */
public class Solution3 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        ListNode pri = listNode;
        ListNode index = listNode.next;
        listNode.next = null;
        ListNode remain;
        while (index != null) {
            remain = index.next;
            index.next = pri;
            pri = index;
            index = remain;
        }
        index = pri;
        while (index != null) {
            list.add(index.val);
            index = index.next;
        }
        return list;
    }
}
