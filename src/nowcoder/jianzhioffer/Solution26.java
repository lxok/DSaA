package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/4/30.
 */
public class Solution26 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode leftStart = Convert(pRootOfTree.left);
        TreeNode rightStart = Convert(pRootOfTree.right);
        if (rightStart != null) {
            pRootOfTree.right = rightStart;
            rightStart.left = pRootOfTree;
        } else {
            pRootOfTree.right = null;
        }
        if (leftStart != null) {
            TreeNode index = leftStart;
            while (index.right != null) {
                index = index.right;
            }
            index.right = pRootOfTree;
            pRootOfTree.left = index;

            leftStart.left = null;
            return leftStart;
        } else {
            pRootOfTree.left = null;
            return pRootOfTree;
        }
    }
}
