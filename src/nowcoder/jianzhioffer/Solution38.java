package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/3.
 */
public class Solution38 {

    int d = 0;

    public int TreeDepth(TreeNode root) {
        dfs(0, root);
        return d;
    }

    public void dfs(int dep, TreeNode node) {
        if (node == null) {
            d = Math.max(d, dep);
            return;
        }
        dfs(dep + 1, node.left);
        dfs(dep + 1, node.right);
    }
}
