package leetcode;

/**
 * Created by nick on 2017/3/1.
 */
/**
 * 题设要求是只有两个元素被替换，而不是两个节点，两个节点则这个题就不好做了。
 * 这个问题实际上就是求逆序的问题。
 * 逆序有两种可能：相邻和不相邻。
 * 最后把逆序的两个元素调换即可。
 */
public class Solution99 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode mis1;
    TreeNode mis2;
    TreeNode pre;

    public void recoverTree(TreeNode root) {
        dfs(root);
        if (mis1 != null && mis2 != null) {
            int tmp = mis1.val;
            mis1.val = mis2.val;
            mis2.val = tmp;
        }
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != null && root.val < pre.val) {
            if (mis1 == null) {
                mis1 = pre;
                mis2 = root;
            } else {
                mis2 = root;
            }
        }
        pre = root;
        dfs(root.right);
    }
}
