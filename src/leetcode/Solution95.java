package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2017/2/25.
 */
public class Solution95 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = subTrees(1, n);
        return res;
    }

    public List<TreeNode> subTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start == end) {
            TreeNode node = new TreeNode(start);
            res.add(node);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left;
            List<TreeNode> right;
            if (i == start) {
                right = subTrees(start + 1, end);
                for (int j = 0; j < right.size(); j++) {
                    TreeNode theNode = new TreeNode(i);
                    theNode.right = right.get(j);
                    res.add(theNode);
                }
            } else if (i == end) {
                left = subTrees(start, end - 1);
                for (int j = 0; j < left.size(); j++) {
                    TreeNode theNode = new TreeNode(i);
                    theNode.left = left.get(j);
                    res.add(theNode);
                }
            } else {
                left = subTrees(start, i - 1);
                right = subTrees(i + 1, end);
                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        TreeNode theNode = new TreeNode(i);
                        theNode.left = left.get(j);
                        theNode.right = right.get(k);
                        res.add(theNode);
                    }
                }
            }
        }
        return res;
    }
}
