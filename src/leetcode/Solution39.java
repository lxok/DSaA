package leetcode;

import java.util.*;

/**
 * Created by nick on 2016/12/26.
 */
public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> tmpList = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        dfs(res, tmpList, candidates, target);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, int[] candidates, int target) {
        int sum = 0;
        Iterator<Integer> i = list.iterator();
        while (i.hasNext()) {
            int k =  i.next();
            sum += k;
        }
        int tmp;
        int index;
        for (int j = 0; j < candidates.length; j++) {
            if (list.size() >=1 && candidates[j] < list.get(list.size() - 1)) {
                continue;
            }
            tmp = sum + candidates[j];
            if (tmp < target) {
                list.add(candidates[j]);
                index = list.size();
                dfs(res, list, candidates, target);
                list.remove(index - 1);
            }  else if (tmp == target) {
                list.add(candidates[j]);
                List<Integer> tmpList = new LinkedList<>();
                tmpList.addAll(list);
                index = list.size();
                res.add(tmpList);
                list.remove(index - 1);
            }
        }
    }
}
