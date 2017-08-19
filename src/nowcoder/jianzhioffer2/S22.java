package nowcoder.jianzhioffer2;

import java.util.ArrayList;

/**
 * Created by nick on 2017/7/8.
 */
public class S22 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        dfs(res, list, 0, root, target);
        return res;
    }

    public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int sum, TreeNode root, int target) {
        if (root == null) {
            return;
        }
        sum += root.val;
        if (sum > target) {
            return;
        }
        if (sum == target) {
            if (root.left == null && root.right == null) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.addAll(list);
                tmp.add(root.val);
                res.add(tmp);
            }
            return;
        }
        list.add(root.val);
        dfs(res, list, sum, root.left, target);
        dfs(res, list, sum, root.right, target);
        list.remove(list.size() - 1);
    }
}
