package leetcode;

import java.util.*;

/**
 * Created by nick on 2016/12/31.
 */
public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        List<Integer> list = new LinkedList<>();
        dfs(res, list, set);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, Set<Integer> remain) {
        if (remain.size() == 0) {
            List<Integer> copy = new LinkedList<>();
            copy.addAll(list);
            res.add(copy);
            return;
        }
        Iterator<Integer> ite = remain.iterator();
        int index;
        int[] range = new int[remain.size()];
        int i = 0;
        while (ite.hasNext()) {
            range[i++] = ite.next();
        }
        for (int j = 0; j < range.length; j++) {
            list.add(range[j]);
            index = list.size() - 1;
            remain.remove(range[j]);
            dfs(res, list, remain);
            list.remove(index);
            remain.add(range[j]);
        }
    }

    public static void main(String[] args) {
        Solution46 s = new Solution46();
        s.permute(new int[]{1,2,3});
    }
}
