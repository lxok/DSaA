package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by acer on 2017/1/25.
 */
/**
 * 子集问题和组合问题可以归纳为同一类问题，组合问题限定元素个数，而子集问题不限定
 * 元素个数，即子集问题是组合问题的拓展。
 *
 * 解法也完全相同，都是利用dfs的思路。考虑解的第一个值是哪个，然后分叉，接着考虑第二个，
 * 第三个，....等等。
 */
public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            List<Integer> empty = new ArrayList<>();
            res.add(empty);
            return res;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        dfs(res, list, nums, -1);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int path) {
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.addAll(list);
        res.add(tmp);

        for (int i = path + 1; i < nums.length; i++) {
            if (i > path + 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            int size = list.size();
            dfs(res, list, nums, i);
            list.remove(size - 1);
        }
    }

    public static void main(String[] args) {
        Solution90 s = new Solution90();
        s.subsetsWithDup(new int[]{1, 2, 2});
    }
}
