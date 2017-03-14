package leetcode;

/**
 * Created by nick on 2017/3/9.
 */
/**
 * 题很简单，但是有个coner case没有考虑
 * 即根节点一边有节点，另一半为空，这样计算高度的方式应该以另一边的为准。
 * 因此将根节点单独考虑。
 */
public class Solution111 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0) {
            return right + 1;
        } else if (right == 0) {
            return left + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(left, right) + 1;
    }
}
