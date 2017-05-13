package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/8.
 */
public class Solution58 {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return sym(pRoot.left, pRoot.right);
    }

    boolean sym(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            if (node1 == null && node2 == null) {
                return true;
            }
            return false;
        }
        return node1.val == node2.val && sym(node1.left, node2.right) && sym(node1.right, node2.left);
    }
}
