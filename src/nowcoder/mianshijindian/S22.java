package nowcoder.mianshijindian;

/**
 * Created by nick on 2017/6/14.
 */
public class S22 {
    int pre = Integer.MIN_VALUE;

    public boolean checkBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if(!checkBST(root.left)) {
            return false;
        }
        if (root.val < pre) {
            return false;
        }
        pre = root.val;
        return checkBST(root.right);
    }
}
