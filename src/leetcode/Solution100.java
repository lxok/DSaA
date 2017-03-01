package leetcode;

/**
 * Created by nick on 2017/3/1.
 */
public class Solution100 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean leftResult = isSameTree(p.left, q.left);
        if (!leftResult) {
            return false;
        }
        boolean rightResult = isSameTree(p.right, q.right);
        if (!rightResult) {
            return false;
        }
        return true;
    }
}
