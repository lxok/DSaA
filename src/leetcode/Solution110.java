package leetcode;

/**
 * Created by nick on 2017/3/9.
 */
public class Solution110 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        int res = dfs(root);
        if (res == -1) {
            return false;
        }
        return true;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        if (left == -1) {
            return -1;
        }
        int right = dfs(root.right);
        if (right == -1) {
            return -1;
        }
        if (left - right > 1 || right - left > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
