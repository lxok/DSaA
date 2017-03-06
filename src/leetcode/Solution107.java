package leetcode;

import java.util.*;

/**
 * Created by nick on 2017/3/6.
 */
public class Solution107 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        List tmpList = new ArrayList();
        TreeNode index;
        while (!que.isEmpty()) {
            tmpList = new ArrayList<>();
            int size = que.size();
            for (int i = 0; i < size; i++) {
                index = que.poll();
                tmpList.add(index.val);
                if (index.left != null) {
                    que.offer(index.left);
                }
                if (index.right != null) {
                    que.offer(index.right);
                }
            }
            res.add(tmpList);
        }
        Collections.reverse(res);
        return res;
    }
}
