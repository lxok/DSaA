package leetcode;

/**
 * Created by nick on 2017/3/9.
 */
public class Solution108 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int start, int end) {
        int medium = (start + end) / 2;
        TreeNode node = new TreeNode(nums[medium]);
        if (start == end) {
            return node;
        }
        if (medium > start) {
            node.left = dfs(nums, start, medium - 1);
        }
        if (medium < end) {
            node.right = dfs(nums, medium + 1, end);
        }
        return node;
    }
}
