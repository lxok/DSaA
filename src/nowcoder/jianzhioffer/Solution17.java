package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/4/27.
 */
public class Solution17 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        if (isSubTree(root1, root2)) {
            return true;
        } else {
            return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
    }

    public boolean isSubTree(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        return node1.val == node2.val && isSubTree(node1.left, node2.left) && isSubTree(node1.right, node2.right);
    }
}
