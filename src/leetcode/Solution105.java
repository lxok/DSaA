package leetcode;

/**
 * Created by nick on 2017/3/5.
 */
/**
 * 已知先序中序生成树的问题，这种问题头一次做.
 * 普通思路还是递归来做，判定每一个节点的左子数范围和右子数范围。
 * 本身递归的思路就在于先完成子节点，最后完成当前节点。
 *
 * 先序的第一个元素是该树的根，后序的最后一个元素是该树的根。
 */
public class Solution105 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        TreeNode root = new TreeNode(preorder[preBegin]);
        if (preEnd == preBegin) {
            return root;
        }
        int i = inBegin;
        while (i <= inEnd) {
            if (inorder[i] == preorder[preBegin]) {
                break;
            }
            i++;
        }
        if (i < inEnd) {
            root.right = build(preorder, preEnd - (inEnd - i) + 1, preEnd, inorder, i + 1, inEnd);
        }
        if (i > inBegin) {
            root.left =  build(preorder, preBegin + 1, preBegin + i - inBegin, inorder, inBegin, i - 1);
        }
        return root;
    }
}
