package nowcoder.mianshijindian;

/**
 * Created by nick on 2017/6/14.
 */
public class S23 {
    public int findSucc(TreeNode root, int p) {
        TreeNode index = root;
        while (index != null) {
            if (p < index.val) {
                index = index.left;
            } else if (p > index.val) {
                index = index.right;
            } else {
                if (index.right == null) {
                    return -1;
                }
                TreeNode min = index.right;
                while (min.left != null) {
                    min = min.left;
                }
                return min.val;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}
