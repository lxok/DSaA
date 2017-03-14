package leetcode;

/**
 * Created by nick on 2017/3/14.
 */
public class Solution116 {
    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode firstNode = root;
        TreeLinkNode upIndex = root;
        TreeLinkNode pri;
        while (upIndex.left != null) {
            firstNode = upIndex.left;
            pri = firstNode;
            pri.next = upIndex.right;
            pri = pri.next;
            upIndex = upIndex.next;
            while (upIndex != null) {
                pri.next = upIndex.left;
                pri.next.next = upIndex.right;
                pri = pri.next.next;
                upIndex = upIndex.next;
            }
            pri.next = null;
            upIndex = firstNode;
        }
    }

    public static void main(String[] args) {
        Solution116 s = new Solution116();
        TreeLinkNode root = s.new TreeLinkNode(1);
        TreeLinkNode left = s.new TreeLinkNode(2);
        TreeLinkNode right = s.new TreeLinkNode(3);
        root.left = left;
        root.right = right;
        s.connect(root);
    }
}
