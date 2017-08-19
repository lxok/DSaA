package nowcoder.jianzhioffer2;

/**
 * Created by nick on 2017/7/8.
 */
public class S24 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        return dfs(pRootOfTree);
    }

    public TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = dfs(node.left);
        TreeNode back;
        if (left != null) {
            back = left;
            while (back.right != null ) {
                back = back.right;
            }
            back.right = node;
            node.left = back;
        } else {
            left = node;
        }
        left.left = null;
        TreeNode right = dfs(node.right);
        if (right != null) {
            node.right = right;
            right.left = node;
        }
        return left;
    }
}
