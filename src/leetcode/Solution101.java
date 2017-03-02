package leetcode;

/**
 * Created by nick on 2017/3/2.
 */
public class Solution101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSym(root.left, root.right);
    }

    public boolean isSym(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        boolean res1 = isSym(root1.left, root2.right);
        boolean res2 = isSym(root1.right, root2.left);
        if (!res1 || !res2) {
            return false;
        }
        return true;
    }
}
