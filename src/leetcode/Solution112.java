package leetcode;

/**
 * Created by nick on 2017/3/11.
 */
public class Solution112 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return dfs(root, sum, 0);
    }

    public boolean dfs(TreeNode root, int sum, int primSum) {
        if (root == null) {
            if (sum == primSum) {
                return true;
            }
            return false;
        }
        primSum += root.val;
        if (dfs(root.left, sum, primSum)) {
            return true;
        }
        return dfs(root.right, sum, primSum);
    }
}
