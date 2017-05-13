package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/9.
 */
public class Solution62 {
    int target;
    int cur = 0;
    boolean flag = false;
    TreeNode res;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        target = k;
        dfs(pRoot);
        if (flag) {
            return res;
        }
        return null;
    }

    public void dfs(TreeNode node) {
        if (node == null || flag) {
            return;
        }
        dfs(node.left);
        if (++cur == target) {
            flag = true;
            res = node;
        }
        dfs(node.right);
    }
}
