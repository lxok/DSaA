package nowcoder.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nick on 2017/5/8.
 */
public class Solution60 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(pRoot);
        TreeNode node;
        while (que.size() != 0) {
            ArrayList<Integer> list = new ArrayList<>(que.size());
            int size = que.size();
            for (int i = 0; i < size; i++) {
                node = que.poll();
                list.add(node.val);
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
