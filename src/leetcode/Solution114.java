package leetcode;

/**
 * Created by nick on 2017/3/12.
 */
public class Solution114 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode index;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        index = root;
        dfs(root);
        index.right = null;
        index.left = null;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        index.right = node;
        index.left = null;
        index = node;
        dfs(left);
        dfs(right);
    }
}
