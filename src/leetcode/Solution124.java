package leetcode;

/**
 * Created by nick on 2017/3/19.
 */
/**
 * 独立完成，思路清晰，爽！！！
 * 代码略冗余，不管了。
 * 还是修改了一下，不冗余了。
 */
public class Solution124 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    int max = Integer.MIN_VALUE;

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int tmp = compMax3(node.val, node.val + left, node.val + right);
        if (tmp > max) {
            max = tmp;
        }
        int conn = node.val + left + right;
        if (conn > max) {
            max = conn;
        }
        return tmp;
    }

    public int compMax3(int a, int b, int c) {
        int val;
        if (a > b) {
            val = a;
        } else {
            val = b;
        }
        if (val < c) {
            val = c;
        }
        return val;
    }
}
