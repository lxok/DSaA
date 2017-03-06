package leetcode;

import java.util.*;

/**
 * Created by nick on 2017/3/4.
 */
/**
 * 这道题对我来说有三个新意：
 * 1. bfs，广度优先遍历，使用队列完成，头一次写。
 * 2. Queue接口使用，由LinkedList实现。
 * 3. Collections类，相当于Arrays类，提供了诸多常用集合变化，这次使用的是翻转。
 */
public class Solution103 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int num;
        boolean direc = true;
        while (!queue.isEmpty()) {
            num = queue.size();
            list = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                TreeNode index = queue.poll();
                list.add(index.val);
                if (index.left != null) {
                    queue.offer(index.left);
                }
                if (index.right != null) {
                    queue.offer(index.right);
                }
            }
            if (direc) {
                res.add(list);
                direc = false;
            } else {
                Collections.reverse(list);
                res.add(list);
                direc = true;
            }
        }
        return res;
    }
}
