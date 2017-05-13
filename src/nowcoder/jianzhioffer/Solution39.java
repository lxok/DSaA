package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/3.
 */
public class Solution39 {
    public boolean IsBalanced_Solution(TreeNode root) {
        return dfs(root) == -1 ? false : true;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        if (left == -1 || right == -1) {
            return -1;
        }
        if (left > right && left - right > 1) {
            return -1;
        }
        if (right > left && right - left > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
