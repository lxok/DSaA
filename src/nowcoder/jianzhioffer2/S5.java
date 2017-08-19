package nowcoder.jianzhioffer2;

/**
 * Created by nick on 2017/7/4.
 */
public class S5 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        return tree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode tree(int[] pre, int l, int r, int[] in, int p, int q) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            return new TreeNode(pre[l]);
        }
        TreeNode root = new TreeNode(pre[l]);
        int i;
        for (i = p; i <= q; i++) {
            if (in[i] == pre[l]) {
                break;
            }
        }
        int count = i - p;
        root.left = tree(pre, l + 1, l + 1 + count - 1, in, p, i - 1);
        root.right = tree(pre, l + 1 + count, r, in, i + 1, q);
        return root;
    }
}
