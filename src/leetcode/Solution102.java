package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2017/3/2.
 */
public class Solution102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(res, 0, root);
        return res;
    }

    public void dfs(List<List<Integer>> res, int level, TreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> cur;
        if ( level > res.size() - 1) {
            cur = new ArrayList<>();
            res.add(cur);
        } else {
            cur = res.get(level);
        }
        cur.add(root.val);
        dfs(res, level + 1, root.left);
        dfs(res, level + 1, root.right);
    }
}
