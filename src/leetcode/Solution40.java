package leetcode;

import java.util.*;

/**
 * Created by nick on 2016/12/27.
 */
/**
 * 需要过滤掉兄弟节点中的相同元素
 */
public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> tmpList = new LinkedList<>();
        dfs(res, tmpList, 0, candidates, target);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, int index, int[] candidates, int target) {
        int sum = 0;
        Iterator<Integer> i = list.iterator();
        while (i.hasNext()) {
            sum += i.next();
        }
        int tmp;
        int tmpIndex;
        for (int j = index; j < candidates.length; j++) {
            if (j >= index + 1 && candidates[j] == candidates[j - 1]) {
                continue;
            }
            tmp = sum + candidates[j];
            if (tmp < target) {
                list.add(candidates[j]);
                tmpIndex = list.size() - 1;
                dfs(res, list, j + 1, candidates, target);
                list.remove(tmpIndex);
            } else if (tmp == target) {
                list.add(candidates[j]);
                List<Integer> addList = new ArrayList<>();
                tmpIndex = list.size() - 1;
                addList.addAll(list);
                res.add(addList);
                list.remove(tmpIndex);
            }
        }
    }
}
