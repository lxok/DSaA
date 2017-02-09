package leetcode;

/**
 * Created by nick on 2016/12/17.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) {
            return null;
        }
        merge(lists, 0, lists.length - 1);
        return lists[0];
    }

    public void merge(ListNode[] list, int start, int end) {
        if (start == end) {
            return;
        }
        int split;
        if (end - start > 1) {
            split = (end + start) / 2;
            merge(list, start, split);
            merge(list, split + 1, end);
            doMerge(list, start, split + 1);
            return;
        }
        if (end - start == 1) {
            doMerge(list, start, end);
        }
    }

    public void doMerge(ListNode[] list, int l1, int l2) {
        ListNode index1 = list[l1];
        ListNode index2 = list[l2];
        ListNode res = new ListNode(-1);
        ListNode index3 = res;
        while(index1 != null && index2 != null) {
            if (index1.val <= index2.val) {
                index3.next = index1;
                index1 = index1.next;
            } else {
                index3.next = index2;
                index2 = index2.next;
            }
            index3 = index3.next;
        }
        if (index1 == null) {
            index3.next = index2;
        }
        if (index2 == null) {
            index3.next = index1;
        }
        list[l1] = res.next;
    }
}
