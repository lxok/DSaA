package leetcode;

/**
 * Created by nick on 2017/3/1.
 */
/**
 * 这道题就是在考察BST成立的条件。
 */

public class Solution98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftTree = isValidBST(root.left);
        boolean rightTree = isValidBST(root.right);
        boolean leftNode = root.left == null ? true: root.val > getMax(root.left);
        boolean rightNode = root.right == null ? true: root.val < getMin(root.right);
        return leftTree && rightTree && leftNode && rightNode;
    }

    public int getMax(TreeNode root) {
        TreeNode index = root;
        while (index.right != null) {
            index = index.right;
        }
        return index.val;
    }

    public int getMin(TreeNode root) {
        TreeNode index = root;
        while (index.left != null) {
            index = index.left;
        }
        return index.val;
    }
}
