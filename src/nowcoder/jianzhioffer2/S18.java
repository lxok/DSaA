package nowcoder.jianzhioffer2;

/**
 * Created by nick on 2017/7/6.
 */
public class S18 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return dfs(root1, root2);
    }

    public boolean dfs(TreeNode root1, TreeNode root2) {
        return isSameTree(root1, root2) || isSameTree(root1.left, root2) || isSameTree(root1.right, root2);
    }

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            if (root2 == null) {
                return true;
            }
            return false;
        }
        if (root2 == null) {
            return true;
        }
        return root1.val == root2.val && isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
}
