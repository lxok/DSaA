package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2017/3/9.
 */
public class Solution109 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int size = 0;
        ListNode index = head;
        while (index != null) {
            size++;
            index = index.next;
        }
        return dfs(head, 0, size - 1);
    }

    public TreeNode dfs(ListNode head, int start, int end) {
        if (start == end) {
            return new TreeNode(head.val);
        }
        int n = (end - start) / 2;
        ListNode index = head;
        int i = 0;
        while (i < n) {
            index = index.next;
            i++;
        }
        TreeNode node = new TreeNode(index.val);
        if (n != 0) {
            node.left = dfs(head, start, start + n - 1);
        }
        if (start + n < end) {
            node.right = dfs(index.next, start + n + 1, end);
        }
        return node;
    }
}
