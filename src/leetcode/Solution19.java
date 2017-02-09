package leetcode;

/**
 * Created by nick on 2016/12/11.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode index = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int flag = 0;
        while (index != null) {
            map.put(flag, index);
            flag++;
            index = index.next;
        }
        int dnode = flag - n;
        ListNode pri;
        if (dnode - 1 < 0) {
            head = head.next;
        } else {
            pri = map.get(dnode - 1);
            ListNode next = map.get(dnode + 1);
            pri.next = next;
        }
        return head;
    }
}
