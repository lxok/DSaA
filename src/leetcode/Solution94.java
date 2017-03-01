package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by nick on 2017/2/24.
 */
/**
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 题目要求不用递归，用迭代
 * 迭代的关键是记录节点上一个节点位置，因此用栈记录
 */
public class Solution94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        dfs(res, root);
        return res;
    }

    public void dfs(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(res, root.left);
        res.add(root.val);
        dfs(res, root.right);
    }

    class Item {
        TreeNode node;
        boolean left;
        boolean right;

        Item(TreeNode node) {
            this.node = node;
            left = false;
            right = false;
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Item> stack = new Stack<>();
        TreeNode index = root;
        Item indexItem = new Item(index);
        stack.push(indexItem);
        while (!stack.empty())  {
            if (!indexItem.left) {
                if (indexItem.node.left != null) {
                    indexItem.left = true;
                    indexItem = new Item(indexItem.node.left);
                    stack.push(indexItem);
                    continue;
                } else {
                    indexItem.left = true;
                    continue;
                }
            }
            if (!indexItem.right) {
                res.add(indexItem.node.val);
                if (indexItem.node.right != null) {
                    indexItem.right = true;
                    indexItem = new Item(indexItem.node.right);
                    stack.push(indexItem);
                    continue;
                } else {
                    indexItem.right = true;
                    continue;
                }
            }
            stack.pop();
            if (!stack.empty()) {
                indexItem = stack.peek();
            } else {
                break;
            }
        }
        return res;
    }
}
