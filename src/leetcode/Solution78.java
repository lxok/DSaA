package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2017/1/10.
 */
public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        dfs(res, list, nums, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        List<Integer> tmp = new ArrayList<>();
        tmp.addAll(list);
        res.add(tmp);

        int size;
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            size = list.size();
            dfs(res, list, nums, i + 1);
            list.remove(size - 1);
        }
    }
}
