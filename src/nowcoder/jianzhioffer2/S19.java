package nowcoder.jianzhioffer2;

/**
 * Created by nick on 2017/7/6.
 */
public class S19 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root);
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
