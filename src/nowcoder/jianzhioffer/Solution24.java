package nowcoder.jianzhioffer;

import java.util.ArrayList;

/**
 * Created by nick on 2017/4/29.
 */
public class Solution24 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(list, 0, target, root);
        return res;
    }

    public void dfs(ArrayList<Integer> list, int sum, int target, TreeNode root) {
        if (root == null) {
            return;
        }
        int val = sum + root.val;
        if (val > target) {
            return;
        } else if (val == target) {
            if (root.left == null && root.right == null) {
                list.add(root.val);
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.addAll(list);
                res.add(tmp);
                list.remove(list.size() - 1);
            } else {
                return;
            }
        } else {
            list.add(root.val);
            sum = val;
            dfs(list, sum, target, root.left);
            dfs(list, sum, target, root.right);
            list.remove(list.size() - 1);
        }
    }
}
