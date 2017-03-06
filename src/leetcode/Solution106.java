package leetcode;

/**
 * Created by nick on 2017/3/6.
 */
public class Solution106 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        TreeNode root = new TreeNode(postorder[postEnd]);
        if (postBegin == postEnd) {
            return root;
        }
        int i = inBegin;
        while (i <= inEnd) {
            if (postorder[postEnd] == inorder[i]) {
                break;
            }
            i++;
        }
        if (i > inBegin) {
            root.left = build(inorder, inBegin, i - 1, postorder, postBegin, postBegin + i - inBegin - 1);
        }
        if (i < inEnd) {
            root.right = build(inorder, i + 1, inEnd, postorder, postEnd - (inEnd - i),postEnd - 1);
        }
        return root;
    }
}
