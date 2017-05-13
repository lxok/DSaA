package nowcoder.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nick on 2017/4/29.
 */
public class Solution22 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> que = new LinkedList();
        que.offer(root);
        while (!que.isEmpty()) {
            TreeNode i = que.poll();
            list.add(i.val);
            if (i.left != null) {
                que.offer(i.left);
            }
            if (i.right != null) {
                que.offer(i.right);
            }
        }
        return list;
    }
}
