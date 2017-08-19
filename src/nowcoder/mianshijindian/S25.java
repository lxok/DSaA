package nowcoder.mianshijindian;

import java.util.ArrayList;

/**
 * Created by nick on 2017/6/15.
 */
public class S25 {
    ArrayList<ArrayList<Integer>> res;

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list, 0, target);
        return res;
    }

    public void dfs(TreeNode node, ArrayList<Integer> list, int sum, int target) {
        if (node == null) {
            return;
        }
        sum += node.val;
        if (sum == target) {
            if (node.left == null && node.right == null) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.addAll(list);
                tmp.add(node.val);
                res.add(tmp);
            }
            return;
        }
        if (sum > target) {
            return;
        }
        list.add(node.val);
        dfs(node.left, list, sum, target);
        dfs(node.right, list, sum, target);
        list.remove(list.size() - 1);
    }
}
