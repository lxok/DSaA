package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nick on 2017/3/28.
 */
public class Solution129 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return sum;
        }
        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        return sum;
    }

    public void dfs(List<Integer> list, TreeNode node) {
        if (node.left == null && node.right == null) {
            list.add(node.val);
            sum += listToInt(list);
            list.remove(list.size() - 1);
            return;
        }

        list.add(node.val);
        if (node.left != null) {
            dfs(list, node.left);
        }
        if (node.right != null) {
            dfs(list, node.right);
        }
        list.remove(list.size() - 1);
    }

    public int listToInt(List<Integer> list) {
        int length = list.size();
        int tmp = 0;
        Iterator<Integer> ite = list.iterator();
        for (int i = length - 1; i >= 0; i--) {
            tmp += ite.next() * Math.pow(10, i);

        }
        return tmp;
    }
}

