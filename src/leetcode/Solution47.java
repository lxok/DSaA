package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nick on 2016/12/31.
 */
public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int remainSize = nums.length;
        List<Integer> list = new ArrayList<>();
        dfs(res, list, nums, remainSize);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int remainSize) {
        if (remainSize == 0) {
            List<Integer> copy = new ArrayList();
            copy.addAll(list);
            res.add(copy);
            return;
        }
        int value;
        int index;
        int previousValue = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MAX_VALUE || nums[i] == previousValue) {
                continue;
            }
            list.add(nums[i]);
            index = list.size() - 1;
            value = nums[i];
            nums[i] = Integer.MAX_VALUE;
            dfs(res, list, nums, remainSize - 1);
            list.remove(index);
            nums[i] = value;
            previousValue = value;
        }
    }
}
