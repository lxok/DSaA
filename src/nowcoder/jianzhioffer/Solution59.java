package nowcoder.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nick on 2017/5/8.
 */
public class Solution59 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(pRoot);
        boolean dir = true;
        TreeNode node;
        while (que.size() != 0) {
            ArrayList<Integer> list = new ArrayList<>(que.size());
            int size = que.size();
            if (dir) {
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
            } else {
                int[] arr = new int[size];
                for (int i = 0; i < size; i++) {
                    node = que.poll();
                    arr[size - 1 - i] = node.val;
                    if (node.left != null) {
                        que.offer(node.left);
                    }
                    if (node.right != null) {
                        que.offer(node.right);
                    }
                }
                for (int i = 0; i < size; i++) {
                    list.add(arr[i]);
                }
            }
            res.add(list);
            dir = !dir;
        }
        return res;
    }
}
