package nowcoder.mianshijindian;

/**
 * Created by nick on 2017/6/11.
 */
public class S18 {
    public boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root) > 0 ? true : false;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftLen = dfs(node.left);
        if (leftLen == -1) {
            return -1;
        }
        int rightLen = dfs(node.right);
        if (rightLen == -1) {
            return -1;
        }
        int max = Math.max(leftLen, rightLen);
        int min = Math.min(leftLen, rightLen);
        if (max - min > 1) {
            return -1;
        }
        return max + 1;
    }
}
