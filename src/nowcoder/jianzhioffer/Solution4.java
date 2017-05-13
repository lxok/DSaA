package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/4/25.
 */
public class Solution4 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return dfs(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode dfs(int[] pre, int preS, int preE, int[] in, int inS, int inE) {
        if (preE == preS) {
            return new TreeNode(pre[preS]);
        }

        TreeNode root = new TreeNode(pre[preS]);
        int i;
        for (i = inS; i <= inE; i++) {
            if (in[i] == pre[preS]) {
                break;
            }
        }
        int leftCount = i - inS;
        int rightCount = inE - i;
        if (leftCount > 0) {
            root.left = dfs(pre, preS + 1, preS + leftCount, in, inS, i - 1);
        }
        if (rightCount > 0) {
            root.right = dfs(pre, preE - rightCount + 1, preE, in, inE - rightCount + 1, inE);
        }
        return root;
    }
}
